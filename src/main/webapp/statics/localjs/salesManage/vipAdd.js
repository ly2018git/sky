
$(function(){
//返回
/*$("#back").click(function(){
    window.location.href=path+"/devApp/appinfolist";
})*/

//检查会员编号是否唯一
$("#vipId").bind("blur",function(){
    var vipId=$("#vipId").val().trim();
    if(vipId!=""){
        //ajax后台验证--vipId是否存在
        $.getJSON("/checkVipId",{"vipId":vipId},
            function success(result){
                console.log(result);
                if(200==result.status){
                    alert("该会员编号可使用");
                        validateTip($("#bianhao"),{"color":"green"},imgYes+"",true);
                }else if(400==result.status){//账号不可用错误提示
                    alert("该会员编号已存在，不能使用！");
                    validateTip($("#bianhao"),{"color":"red"},imgNo+" 该会员编号已存在，不能使用！",false);
                }
            });
    }
});

   /* var vipId=$("#vipId").val();
    var vipName=jQuery("#vipName").val().trim();
    $("#vipName").bind("blur",function() {
        if (vipName.length<4||vipName.length>6) {
            validateTip($("#nicheng"), {"color": "red"}, imgNo + " 昵称不能小于4位大于6位数！", false);
        } else {
            validateTip($("#nicheng"), {"color": "green"}, imgYes + "",true);
        }
    });

    var sex=$("#sex").val();
    var phone=$("#phone").val();
    var address=$("#address").val();
    var testPhone=/^[1][3,4,5,7,8][0-9]{9}$/;
    $("#phone").bind("blur",function() {
        if (!testPhone.test(phone)) {
            validateTip($("#dianhua"), {"color": "red"}, imgNo + " 请输入正确的手机号！", false);
        return false;
        } else {
            validateTip($("#dianhua"), {"color": "green"}, imgYes + "", true);
            return true;
        }
    });*/
//保存,添加会员信息
$("#btn_add").click(function(){
    var vipId=$("#vipId").val();
    var vipName=jQuery("#vipName").val().trim();
    var sex=$("#sex").val();
    var phone=$("#phone").val();
    var address=$("#address").val();
    if(vipId==""||vipName==""||sex==""||phone==""||address==""){
        alert("信息不完整，请补充完整！");
    }else{
        jQuery.ajax({
            url:'/addVip',//服务器端请求地址
            type:'post',
            secureuri:false,//是否需要安全协议，一般设置为false
            contentType:'application/json;charset=utf-8',
            dataType:'json',//返回之类型一般设置为json
            data:JSON.stringify({
                "vipId":vipId,
                "vipName":vipName,
                "sex":sex,
                "phone":phone,
                "address":address
            }),
            success:function(result){
                console.log(result);
                if(200==result.status){
                    alert("保存成功");
                    window.location.href=path+"/vipManage";
                }else{
                   /* $("#AddError").html(result.msg);*/
                    alert("保存失败！");
                }
            },
            error:function(data,status,e){
                alert("请求失败，请稍后重试");
            }
        })
    }
});

});