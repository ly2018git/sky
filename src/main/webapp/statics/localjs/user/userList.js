/*
 *分页显示人事列表
 */
function getuserPage(pageIndex){
    //获取各种条件
    //用户名称
    var userName=jQuery("#userName").val();
    //获取当前登录用户的id 数据存放在cookie中调用publicUtil.js公共js getCookie(cookieKeyName,cookieValueName)
    //var devId=getCookie("appUser","id");
    //每页数据数量
    var pageSize=5;
    jQuery.ajax({
        type:"post",
        url:"/user/getuserPage",
        dataType:"json",
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({
            "UName":userName,
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
                            '<td>'+result.data.list[i].uID+'</td>' +
                            '<td class="center">'+result.data.list[i].uName+'</td>'+
                            '<td>'+result.data.list[i].sex+'</td>' +
                            '<td>'+result.data.list[i].phone+'</td>' +
                            '<td class="center"> ' +
                            '<select name="selection" id="roleName">' +
                            '<option value="'+result.data.list[i].rID+'" selected="selected">'+result.data.list[i].rName+'</option>' +
                            '</select></td>' +
                            '<td class="center">'+result.data.list[i].address+'</td>' +
                            '<td class="center"><button>修改角色</button> &nbsp; ' +
                            '<button >删除用户</button></td>';
                        pageStr+='</tr>';
                    }
                }
                $("#userPage").html(pageStr);
                /*document.getElementById("appInfoPage").innerHTML=pageStr;*/
                $("#pageCount").html(result.data.totalCount);
                $("#pageIndex").html(result.data.pageIndex);
                $("#totalPageCount").html(result.data.totalPageCount);

                $("#hid_pageIndex").val(result.data.pageIndex);
                $("#hid_totalPageCount").val(result.data.totalPageCount);
            }else{
                pageStr='<h3>暂无相关数据</h3>';
                $("#userPage").html(pageStr);
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
        getuserPage(num);
    }
}



jQuery(document).ready(function(){
    //下拉框
    loadRoleName();
    //查询第一页数据
    getuserPage(1);

    //条件查询按钮
    jQuery(".user").keydown(function(){
        getuserPage(1);
    });
//首页
    jQuery("#homePage").click(function(){
        getuserPage(1);
    });
//上一页
    jQuery("#prevPage").click(function(){
        var pageIndex=parseInt($("#hid_pageIndex").val());
        getuserPage(pageIndex-1>=1?pageIndex-1:1);

    });
//下一页
    jQuery("#nextPage").click(function(){
        var pages=parseInt($("#hid_totalPageCount").val());
        var pageIndex=parseInt($("#hid_pageIndex").val());
        getuserPage(pageIndex+1<=pages?pageIndex+1:pages);

    });
//末页
    jQuery("#endPage").click(function(){
        var pages=parseInt($("#hid_totalPageCount").val());
        getuserPage(pages);
    });

});

/*查询所有角色*/
function loadRoleName(){
    jQuery.ajax({
        type:"get",
        url:"/user/getAllRole",
        dataType:"json",
        contentType:"application/json;charset=utf-8",
        data:{},
        success:function(result){
            console.log(result);
            var optionStr="<option value='' selected='selected'>--请选择--</option>";
            if(200==result.status){
                if(result.data!=null){
                    for(var t=0;t<result.data.length;t++){
                        optionStr+="<option value='"+result.data[t].rid+"'>"+result.data[t].rname+"</option>";
                    }
                }
                $("#roleName").html(optionStr);
            }
        }
    });
}