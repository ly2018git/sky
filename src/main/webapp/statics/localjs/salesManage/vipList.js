
//根据id查看修改的对应信息
//查看Vip详情信息
function modify(id) {
    window.location.href="/vip/vipModify?id=" + id;
};



//删除Vip部分  onclick="delVip('+result.data.list[i].id+')"



function delVip(id){
    if(confirm("你确定要删除该会员吗？")) {
        jQuery.ajax({
            type: "get",
            url: "/vip/delVip",
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            data: {
                "id":id,
            },
            success: function (result) {
                console.log(result);
                if (200 == result.status) {
                    alert("删除成功！");
                    var pageIndex=parseInt($("#hid_pageIndex").val());
                    getVipInfoPage(pageIndex);
                }else if(400==result.status){
                    alert("对不起，删除会员失败！")
                }
            }
        });
    }
}






/*
*批量删除
 */
function delVips(){
    //将被选中的值存到数组中
    var obj=document.getElementsByName("check");
    var check_val=[];
    for(var k in obj){
        if(obj[k].checked){
            check_val.push(obj[k].value);
        }
    }
    if(confirm("你确定要删除该会员吗？")) {
        if(check_val.length>0){

        jQuery.ajax({
            type: "get",
            url: "/vip/delVips",
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            data:{
                "item":check_val
            },
            success: function (result) {
                console.log(result);
                if (200 == result.status) {
                    alert("删除成功！");
                    var pageIndex=parseInt($("#hid_pageIndex").val());

                    getVipInfoPage(pageIndex);
                }else if(400==result.status){
                    alert("对不起，删除会员失败！");
                }
            }
        });
        }else{
            alert("请选择要删除的会员！");
        }
    }
}

/*
 *分页显示会员列表
 */
function getVipInfoPage(pageIndex){


    //获取各种条件
    var vipId=jQuery("#vipId").val();
    var phone=jQuery("#phone").val().trim();
    //获取当前登录用户的id 数据存放在cookie中调用publicUtil.js公共js getCookie(cookieKeyName,cookieValueName)
    //var devId=getCookie("appUser","id");
    //每页数据数量
    var pageSize=5;
        jQuery.ajax({
            type:"post",
            url:"vip/getVipInfoPage",
            dataType:"json",
            contentType:"application/json;charset=utf-8",
            data:JSON.stringify({
                "id":vipId,
                "phone":phone,
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
                                '<td align="center"><div class="" id=""><span class><input type="checkbox" style=""name="check" value="'+result.data.list[i].id+'" ></span></div></td>' +
                                '<td>'+result.data.list[i].id+'</td>'+
                                '<td>'+result.data.list[i].vipLevel+'</td>'+
                                '<td>'+result.data.list[i].vipName+'</td>'+
                                '<td>'+result.data.list[i].integral+'</td>'+
                                '<td class="center">'+result.data.list[i].phone+'</td>'+
                                '<td class="center">'+result.data.list[i].address+'</td>'+
                                '<td class="center"><a href="javascript:;" class="edits" vipid='+result.data.list[i].id+' onclick="modify('+result.data.list[i].id+')" >编辑</a> &nbsp; ' +
                                '<a href="javascript:;" class="deleteVip" vipname='+result.data.list[i].vipName+' vipid='+result.data.list[i].id+' onclick="delVip('+result.data.list[i].id+')" >删除</a></td>';
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
/*分页输入框*/
function jump_to(num){
    //alert(num);
    //验证用户的输入
    var regexp=/^[1-9]\d*$/;
    var totalPageCount = jQuery("#hid_totalPageCount").val();
    if(!regexp.test(num)){
        alert("请输入大于0的正整数！");
        return false;
    }else if((num-totalPageCount) > 0){
        alert("请输入小于总页数的页码");
        return false;
    }else{
            getVipInfoPage(num);
    }
}


jQuery(document).ready(function(){
   //批量删除选择
    $("#allAndNotAll").click(function() {
        var flag=this.checked;
        $("input[name='check']").each(function () {
         $(this).attr("checked",flag);

        });

    });
    //

        //条件查询按钮
   /* jQuery(".vip").keydown(function(){
        getVipInfoPage(1);
    });*/
$("#btn_query").click(function(){
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




});