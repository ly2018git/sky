
/*
 *分页显示销售营业额列表
 */
function getCounterInfoPage(pageIndex){
    //获取各种条件c
    //药品名称
    var medicineName=jQuery("#medicineName").val();
    //获取当前登录用户的id 数据存放在cookie中调用publicUtil.js公共js getCookie(cookieKeyName,cookieValueName)
    //var devId=getCookie("appUser","id");
    //每页数据数量
    var pageSize=5;
    jQuery.ajax({
        type:"post",
        url:"/getCounterInfoPage",
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
                            '<td>'+result.data.list[i].counterId+'</td>' +
                            '<td class="center">'+result.data.list[i].medicineName+'</td>'+
                            '<td>'+result.data.list[i].commonName+'</td>' +
                            '<td>'+result.data.list[i].specificationName+'</td>' +
                            '<td class="center">'+result.data.list[i].manufacturerName+'</td>';
                        if(result.data.list[i].isPrescription==0){
                            pageStr+= '<td class="center">处方药</td>';
                        }
                        if(result.data.list[i].isPrescription==1){
                            pageStr+= '<td class="center">非处方药</td>';
                        }
                        pageStr+= '<td class="center">'+result.data.list[i].salePrice+'</td>' +
                            '<td class="center">'+result.data.list[i].number+'</td>'+
                            '<td class="center">'+result.data.list[i].iODate+'</td>'+
                            '<td class="center">'+result.data.list[i].saitemNumber+'</td>'+
                            '<td class="center"><a href="" class="edit">编辑</a></td>';

                        pageStr+='</tr>';
                    }
                }
                $("#CounterInfoPage").html(pageStr);
                /*document.getElementById("appInfoPage").innerHTML=pageStr;*/
                $("#pageCount").html(result.data.totalCount);
                $("#pageIndex").html(result.data.pageIndex);
                $("#totalPageCount").html(result.data.totalPageCount);

                $("#hid_pageIndex").val(result.data.pageIndex);
                $("#hid_totalPageCount").val(result.data.totalPageCount);
            }else{
                pageStr='<h3>暂无相关数据</h3>';
                $("#CounterInfoPage").html(pageStr);
            }
        }
    });
}

/**
 * 条件查询
 */




jQuery(document).ready(function(){
    //查询第一页数据
    getCounterInfoPage(1);

    //条件查询按钮
    $("#btn_query").click(function(){
        getCounterInfoPage(1);
    });
//首页
    jQuery("#homePage").click(function(){
        getCounterInfoPage(1);
    });
//上一页
    jQuery("#prevPage").click(function(){
        var pageIndex=parseInt($("#hid_pageIndex").val());
        getCounterInfoPage(pageIndex-1>=1?pageIndex-1:1);

    });
//下一页
    jQuery("#nextPage").click(function(){
        var pages=parseInt($("#hid_totalPageCount").val());
        var pageIndex=parseInt($("#hid_pageIndex").val());
        getCounterInfoPage(pageIndex+1<=pages?pageIndex+1:pages);

    });
//末页
    jQuery("#endPage").click(function(){
        var pages=parseInt($("#hid_totalPageCount").val());
        getCounterInfoPage(pages);
    });

});