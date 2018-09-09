/*
 *分页显示销售营业额列表
 */
function getMaitainInfoPage(pageIndex){
    //获取各种条件
    //药品名称
    var medicineName=jQuery("#medicineName").val();
    //获取当前登录用户的id 数据存放在cookie中调用publicUtil.js公共js getCookie(cookieKeyName,cookieValueName)
    //var devId=getCookie("appUser","id");
    //每页数据数量
    var pageSize=5;
    jQuery.ajax({
        type:"post",
        url:"/gps/getMaitainInfoPage",
        dataType:"json",
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({
            "medicineName":medicineName,
            "pageIndex":pageIndex,
            "pageSize":pageSize
        }),
        success:function(result){
            console.log(result);
            if(200==result.status){
                var pageStr='';
                if(result.data.list.length>0){
                    for (var i = 0; i< result.data.list.length; i++) {
                        pageStr+='<tr>'+
                            '<td>'+result.data.list[i].medicineId+'</td>' +
                            '<td class="center">'+result.data.list[i].medicineName+'</td>'+
                            '<td>'+result.data.list[i].commonName+'</td>' +
                            '<td>'+result.data.list[i].specificationName+'</td>' +
                            '<td class="center">'+result.data.list[i].unitName+'</td>' +
                            '<td class="center">'+result.data.list[i].batchNumber+'</td>' +
                            '<td class="center">'+result.data.list[i].number+'</td>'+
                            '<td class="center">'+result.data.list[i].manufacturerName+'</td>'+
                            '<td class="center">'+result.data.list[i].validity+'</td>'+
                            '<td class="center">'+result.data.list[i].surplus+'</td>';
                        pageStr+='</tr>';
                    }
                }
                $("#drugMaintainGps").html(pageStr);
                /*document.getElementById("appInfoPage").innerHTML=pageStr;*/
                $("#pageCount").html(result.data.totalCount);
                $("#pageIndex").html(result.data.pageIndex);
                $("#totalPageCount").html(result.data.totalPageCount);

                $("#hid_pageIndex").val(result.data.pageIndex);
                $("#hid_totalPageCount").val(result.data.totalPageCount);
            }else{
                pageStr='<h3>暂无相关数据</h3>';
                $("#drugMaintainGps").html(pageStr);
            }
        }
    });
}

/**
 * 条件查询
 */
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
        getMaitainInfoPage(num);
    }
}



jQuery(document).ready(function(){
    //查询第一页数据
    getMaitainInfoPage(1);

    //条件查询按钮
    //条件查询按钮
    jQuery(".medicine").keyup(function(){
        getMaitainInfoPage(1);
    });
//首页
    jQuery("#homePage").click(function(){
        getMaitainInfoPage(1);
    });
//上一页
    jQuery("#prevPage").click(function(){
        var pageIndex=parseInt($("#hid_pageIndex").val());
        getMaitainInfoPage(pageIndex-1>=1?pageIndex-1:1);

    });
//下一页
    jQuery("#nextPage").click(function(){
        var pages=parseInt($("#hid_totalPageCount").val());
        var pageIndex=parseInt($("#hid_pageIndex").val());
        getMaitainInfoPage(pageIndex+1<=pages?pageIndex+1:pages);

    });
//末页
    jQuery("#endPage").click(function(){
        var pages=parseInt($("#hid_totalPageCount").val());
        getMaitainInfoPage(pages);
    });


    /**联动查询，首先查出所有药品信息，当选中某个药品名称时，即选中药品id时，
     *药品销售价跟着动态查出来
     */







});