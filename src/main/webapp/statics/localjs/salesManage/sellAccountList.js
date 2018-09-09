
/*
 *分页显示销售营业额列表
 */
function getSellAccountInfoPage(pageIndex){
    //获取各种条件
    //时间
    var sellDate1=jQuery("#sellDate1").val();
    var sellDate2=jQuery("#sellDate2").val();
    //销售员编号
    var UID=jQuery("#UID").val();
    //获取当前登录用户的id 数据存放在cookie中调用publicUtil.js公共js getCookie(cookieKeyName,cookieValueName)
    //var devId=getCookie("appUser","id");
    //每页数据数量
    var pageSize=5;
    jQuery.ajax({
        type:"post",
        url:"/getSellAccountInfoPage",
        dataType:"json",
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({
            "sellDate1":sellDate1,
            "sellDate2":sellDate2,
            "UID":UID,
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
                            '<td>'+result.data.list[i].sellAccountId+'</td>' +
                            '<td class="center">'+result.data.list[i].uID+'</td>'+
                            '<td>'+result.data.list[i].sellDate+'</td>' +
                            '<td>'+result.data.list[i].vipId+'</td>' +
                            '<td class="center">'+result.data.list[i].actuallyPaid+'</td>' +
                            '<td class="center">'+result.data.list[i].due+'</td>' +
                            '<td class="center">'+result.data.list[i].cutAmount+'</td>'+
                            '<td class="center">'+result.data.list[i].cutComment+'</td>'+
                            '<td class="center">'+result.data.list[i].payWay+'</td>'+
                            '<td class="center">'+result.data.list[i].comment+'</td>'+
                            '<td class="center">'+result.data.list[i].closingDate+'</td>'+

                            '<td class="center">'+result.data.list[i].salesman+'</td>';
                        pageStr+='</tr>';
                    }
                }
                $("#SellAccountInfoPage").html(pageStr);
                /*document.getElementById("appInfoPage").innerHTML=pageStr;*/
                $("#pageCount").html(result.data.totalCount);
                $("#pageIndex").html(result.data.pageIndex);
                $("#totalPageCount").html(result.data.totalPageCount);

                $("#hid_pageIndex").val(result.data.pageIndex);
                $("#hid_totalPageCount").val(result.data.totalPageCount);
            }else{
                pageStr='<h3>暂无相关数据</h3>';
                $("#SellAccountInfoPage").html(pageStr);
            }
        }
    });
}

/**
 * 条件查询
 */




jQuery(document).ready(function(){
    //查询第一页数据
    getSellAccountInfoPage(1);

    //条件查询按钮
    $("#btn_query").click(function(){
        getSellAccountInfoPage(1);
    });
//首页
    jQuery("#homePage").click(function(){
        getSellAccountInfoPage(1);
    });
//上一页
    jQuery("#prevPage").click(function(){
        var pageIndex=parseInt($("#hid_pageIndex").val());
        getSellAccountInfoPage(pageIndex-1>=1?pageIndex-1:1);

    });
//下一页
    jQuery("#nextPage").click(function(){
        var pages=parseInt($("#hid_totalPageCount").val());
        var pageIndex=parseInt($("#hid_pageIndex").val());
        getSellAccountInfoPage(pageIndex+1<=pages?pageIndex+1:pages);

    });
//末页
    jQuery("#endPage").click(function(){
        var pages=parseInt($("#hid_totalPageCount").val());
        getSellAccountInfoPage(pages);
    });

});