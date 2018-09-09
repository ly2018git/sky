jQuery(function (){
    genTimestamp();
    changeCode();
});

// 获取当前时间
function genTimestamp() {
    var time = new Date();
    return time.getTime();
}

// 点击获取验证码
function changeCode() {
    jQuery("#Img").attr("src", "/getVerifyCode?t=" + genTimestamp());
}

jQuery("#success").click(function() {
    var userCode = jQuery("#username").val().trim();
    var userPassword = jQuery("#password").val().trim();
    var code = jQuery("#code").val().trim();
    if(null == userCode && ""==userCode){
        $("#loginmsg").show();
    }else if(null == userPassword && ""==userPassword) {
        $("#loginmsg").show();
    }else if(null == code && ""==code){
        $("#loginmsg").show();
    }else{
        jQuery.ajax({
            url :"/login",
            type : "get",
            dataType : "json",
            contentType:"skyhospital/json;charset=utf-8",
            data : {
                "userName":userCode,
                "userPwd":userPassword,
                "code":code

            },//参数是json时，需要用JSON.sstringify()函数处理
            success : function(result) {
                console.log(result);
                if(200==result.status){
                    window.location="/welcome";
                }else{
                    jQuery("#loginmsg").html(result.msg);
                }
            },
        });
    }
})

