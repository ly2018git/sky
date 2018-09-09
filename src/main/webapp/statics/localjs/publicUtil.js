$("#userView").click(function () {
    var cookieValue = jQuery.cookie("userName") ;
    //显示用户信息到页面中
    $("#name").html(getCookie("userName","UName"));
    $("#UName").html(getCookie("userName","UName"));
    $("#Sex").html(getCookie("userName","sex"))
})

$(function() {
    checkLogin();
});

//获取cookie值 cookieKeyValue:键名称，cookieValueName:值名称
function getCookie(cookieKeyName,cookieValueName){
    //获取cookie值
    var cookieKeyValue=$.cookie(cookieKeyName);
    //判断cookie值是否为空，为空则提示未登录，返回登录页面
    if(undefined!=cookieKeyValue||null!=cookieKeyValue||""!=cookieKeyValue){
        //将cookie值进行分割成数组
        var cookieArray=cookieKeyValue.split("&");
        for (var i = 0; i < cookieArray.length; i++) {
            //将key和value分开
            var array = cookieArray[i].split("=");
            var valueName = array[0].replace(/\s+/g, "");
            var Value=array[1];
            //对比值名称，对应则返回
            if(cookieValueName==valueName){
                if (cookieKeyValue != "") {
                    return decodeURI(Value);
                } else {
                    return "";
                }
            }
        }
    }else{
        alert("用户未登录！请登录");
        window.location.href ="/index";
    }
}
//查询浏览器路径上的数据
function getPath(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}

//验证是否登录
function checkLogin() {
    //获取cookie值
    var cookieValue = jQuery.cookie("userName") ;
    //判断cookie值，未空则提示为登录并跳转登录页面
    if("" == cookieValue || null == cookieValue || undefined == cookieValue){
        alert("用户为登录！请登录");
        window.location.href="/index";
    }else{
        //显示用户信息到页面中
        var roles = getCookie("userName","role");
        $(".name").html(getCookie("userName","UName"));
        $(".roles").html(roles);
        $(".email").html(getCookie("userName","email"));





        var photo = getCookie("userName","photo");//个人证件照
        if(photo == null || photo == ''){
            $("#uploadfile2").html("暂无").show();
        }else{
            $("#logoFile").append('< img src="'+photo+'?m='+ Math.random() +'" width="100px;"/>"');
        }
    }
}


//用户注销
$("#exit").click(function(){
    jQuery.cookie("userName","",{path:'/'});
    window.location.href="/index";
})