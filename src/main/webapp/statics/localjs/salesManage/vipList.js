
/*
 *分页显示会员列表
 */
function getVipInfoPage(pageIndex){
    //获取各种条件
    var vipId=jQuery("#vipId").val();
    //获取当前登录用户的id 数据存放在cookie中调用publicUtil.js公共js getCookie(cookieKeyName,cookieValueName)
    //var devId=getCookie("appUser","id");
    //每页数据数量
    var pageSize=5;
        jQuery.ajax({
            type:"post",
            url:"/getVipInfoPage",
            dataType:"json",
            contentType:"application/json;charset=utf-8",
            data:JSON.stringify({
                "id":vipId,
                "pageIndex":pageIndex,
                "pageSize":pageSize
            }),
            success: function (result) {
                console.log(result);
                if (200 == result.status) {
                    var pageStr = '';
                    if (result.data.list.length > 0) {
                        for (var i = 0; i < result.data.list.length; i++) {
                            pageStr+= '<tr>' +
                                '<td align="center"><div class="checker" id="uniform-undefined"><span class><input type="checkbox" style="opacity: 0;"></span></div></td>' +
                                '<td>'+result.data.list[i].id+'</td>'+
                                '<td>'+result.data.list[i].vipLevel+'</td>'+
                                '<td>'+result.data.list[i].vipName+'</td>'+
                                '<td>'+result.data.list[i].integral+'</td>'+
                                '<td class="center">'+result.data.list[i].phone+'</td>'+
                                '<td class="center">'+result.data.list[i].address+'</td>'+
                                '<td class="center"><a href="" class="edit">编辑</a> &nbsp; <a href="" class="delete">删除</a></td>';
                            pageStr+= '</tr>';
                        }
                    }
                    $("#vipInfoPage").html(pageStr);
                    /*document.getElementById("appInfoPage").innerHTML=pageStr;*/
                    $("#pageCount").html(result.data.totalCount);
                    $("#pageIndex").html(result.data.pageIndex);
                    $("#totalPageCount").html(result.data.totalPageCount);
                    $("#hid_pageIndex").val(result.data.pageIndex);
                    $("#hid_totalPageCount").val(result.data.totalPageCount);
                } else {
                    pageStr = '<h3>暂无相关数据</h3>';
                    $("#vipInfoPage").html(pageStr);
                }
            }
        });
}


/**
 * 条件查询
 */

//条件查询按钮
/*$("#btn_query").click(function(){
    getVipInfoPage(1);
});*/


jQuery(document).ready(function(){
        //条件查询按钮
    jQuery(".vip").keydown(function(){
        getVipInfoPage(1);
    });
//首页
    jQuery("#homePage").click(function(){
        getVipInfoPage(1);
    });
//上一页
    jQuery("#prevPage").click(function(){
        var pageIndex=parseInt($("#hid_pageIndex").val());
        getVipInfoPage(pageIndex-1>=1?pageIndex-1:1);

    });
//下一页
    jQuery("#nextPage").click(function(){
        var pages=parseInt($("#hid_totalPageCount").val());
        var pageIndex=parseInt($("#hid_pageIndex").val());
        getVipInfoPage(pageIndex+1<=pages?pageIndex+1:pages);

    });
//末页
    jQuery("#endPage").click(function(){
        var pages=parseInt($("#hid_totalPageCount").val());
        getVipInfoPage(pages);
    });
    //查询第一页数据
    getVipInfoPage(1);

    jQuery('.stdtablecb .checkall').click(function(){
        var parentTable = jQuery(this).parents('table');
        var ch = parentTable.find('tbody input[type=checkbox]');
        if(jQuery(this).is(':checked')) {

            //check all rows in table
            ch.each(function(){
                jQuery(this).attr('checked',true);
                jQuery(this).parent().addClass('checked');	//used for the custom checkbox style
                jQuery(this).parents('tr').addClass('selected');
            });

            //check both table header and footer
            parentTable.find('.checkall').each(function(){ jQuery(this).attr('checked',true); });

        } else {

            //uncheck all rows in table
            ch.each(function(){
                jQuery(this).attr('checked',false);
                jQuery(this).parent().removeClass('checked');	//used for the custom checkbox style
                jQuery(this).parents('tr').removeClass('selected');
            });

            //uncheck both table header and footer
            parentTable.find('.checkall').each(function(){ jQuery(this).attr('checked',false); });
        }
    });


    ///// PERFORMS CHECK/UNCHECK BOX /////
    jQuery('.stdtablecb tbody input[type=checkbox]').click(function(){
        if(jQuery(this).is(':checked')) {
            jQuery(this).parents('tr').addClass('selected');
        } else {
            jQuery(this).parents('tr').removeClass('selected');
        }
    });

    ///// DELETE SELECTED ROW IN A TABLE /////
    jQuery('.deletebutton').click(function(){
        var tb = jQuery(this).attr('title');							// get target id of table
        var sel = false;												//initialize to false as no selected row
        var ch = jQuery('#'+tb).find('tbody input[type=checkbox]');		//get each checkbox in a table

        //check if there is/are selected row in table
        ch.each(function(){
            if(jQuery(this).is(':checked')) {
                sel = true;												//set to true if there is/are selected row
                jQuery(this).parents('tr').fadeOut(function(){
                    jQuery(this).remove();								//remove row when animation is finished
                });
            }
        });

        if(!sel) alert('请选择要删除的会员');								//alert to no data selected
    });


    ///// DELETE INDIVIDUAL ROW IN A TABLE /////
    jQuery('.stdtable a.delete').click(function(){
        var c = confirm('确定继续删除吗?');
        if(c) jQuery(this).parents('tr').fadeOut(function(){
            jQuery(this).remove();
        });
        return false;
    });

    ///// GET DATA FROM THE SERVER AND INJECT IT RIGHT NEXT TO THE ROW SELECTED /////
    jQuery('.stdtable a.toggle').click(function(){

        //this is to hide current open quick view in a table
        jQuery(this).parents('table').find('tr').each(function(){
            jQuery(this).removeClass('hiderow');
            if(jQuery(this).hasClass('togglerow'))
                jQuery(this).remove();
        });

        var parentRow = jQuery(this).parents('tr');
        var numcols = parentRow.find('td').length + 1;				//get the number of columns in a table. Added 1 for new row to be inserted
        var url = jQuery(this).attr('href');

        //this will insert a new row next to this element's row parent
        parentRow.after('<tr class="togglerow"><td colspan="'+numcols+'"><div class="toggledata"></div></td></tr>');

        var toggleData = parentRow.next().find('.toggledata');

        parentRow.next().hide();

        //get data from server
        jQuery.post(url,function(data){
            toggleData.append(data);						//inject data read from server
            parentRow.next().fadeIn();						//show inserted new row
            parentRow.addClass('hiderow');					//hide this row to look like replacing the newly inserted row
            jQuery('input,select').uniform();
        });

        return false;
    });


    ///// REMOVE TOGGLED QUICK VIEW WHEN CLICKING SUBMIT/CANCEL BUTTON /////
    jQuery('.toggledata button.cancel, .toggledata button.submit').live('click',function(){
        jQuery(this).parents('.toggledata').animate({height: 0},200, function(){
            jQuery(this).parents('tr').prev().removeClass('hiderow');
            jQuery(this).parents('tr').remove();
        });
        return false;
    });



    /*jQuery('#dyntable').dataTable({
        "sPaginationType": "full_numbers"
    });*/

  /*  jQuery('#dyntable2').dataTable({
        "sPaginationType": "full_numbers",
        "aaSortingFixed": [[0,'asc']],
        "fnDrawCallback": function(oSettings) {
            jQuery('input:checkbox,input:radio').uniform();
            //jQuery.uniform.update();
        }
    });*/


    ///// TRANSFORM CHECKBOX AND RADIO BOX USING UNIFORM PLUGIN /////
   /* jQuery('input:checkbox,input:radio').uniform();*/


});