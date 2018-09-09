
/*
 *分页显示会员列表
 */
function getSellItemInfoPage(pageIndex){
    //获取各种条件
    //时间
    var sellDate1=jQuery("#sellDate1").val();
    var sellDate2=jQuery("#sellDate2").val();
    //药品名称
    var medicineName=jQuery("#medicineName").val();
    //获取当前登录用户的id 数据存放在cookie中调用publicUtil.js公共js getCookie(cookieKeyName,cookieValueName)
    //var devId=getCookie("appUser","id");
    //每页数据数量
    var pageSize=5;
    jQuery.ajax({
        type:"post",
        url:"/getSellItemInfoPage",
        dataType:"json",
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({
            "sellDate1":sellDate1,
            "sellDate2":sellDate2,
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
                            '<td>'+result.data.list[i].medicineName+'</td>' +
                            '<td>'+result.data.list[i].commonName+'</td>' +
                            '<td class="center">'+result.data.list[i].specificationName+'</td>' +
                            '<td class="center">'+result.data.list[i].manufacturerName+'</td>' +
                            '<td class="center">'+result.data.list[i].standardCode+'</td>' ;
                            if(result.data.list[i].isPrescription==0){
                                pageStr+= '<td class="center">处方药</td>';
                            }
                            if(result.data.list[i].isPrescription==1){
                                pageStr+= '<td class="center">非处方药</td>';
                            }
                        pageStr+='<td class="center">'+result.data.list[i].purchasePrice+'</td>'+
                        '<td class="center">'+result.data.list[i].number+'</td>'+
                            '<td class="center">'+result.data.list[i].retailStdPrice+'</td>'+
                        '<td class="center">'+result.data.list[i].comment+'</td>'+
                        '<td class="center">'+result.data.list[i].sellDate+'</td>';
                            pageStr+='</tr>';
                    }
                }
                $("#SellItemInfoPage").html(pageStr);
                /*document.getElementById("appInfoPage").innerHTML=pageStr;*/
                $("#pageCount").html(result.data.totalCount);
                $("#pageIndex").html(result.data.pageIndex);
                $("#totalPageCount").html(result.data.totalPageCount);

                $("#hid_pageIndex").val(result.data.pageIndex);
                $("#hid_totalPageCount").val(result.data.totalPageCount);
            }else{
                pageStr='<h3>暂无相关数据</h3>';
                $("#SellItemInfoPage").html(pageStr);
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
        getSellItemInfoPage(num);
    }
}



jQuery(document).ready(function(){

    //查询第一页数据
    getSellItemInfoPage(1);

    //条件查询按钮
    $("#btn_query").click(function(){
        getSellItemInfoPage(1);
    });
//首页
    jQuery("#homePage").click(function(){
        getSellItemInfoPage(1);
    });
//上一页
    jQuery("#prevPage").click(function(){
        var pageIndex=parseInt($("#hid_pageIndex").val());
        getSellItemInfoPage(pageIndex-1>=1?pageIndex-1:1);

    });
//下一页
    jQuery("#nextPage").click(function(){
        var pages=parseInt($("#hid_totalPageCount").val());
        var pageIndex=parseInt($("#hid_pageIndex").val());
        getSellItemInfoPage(pageIndex+1<=pages?pageIndex+1:pages);

    });
//末页
    jQuery("#endPage").click(function(){
        var pages=parseInt($("#hid_totalPageCount").val());
        getSellItemInfoPage(pages);
    });

});