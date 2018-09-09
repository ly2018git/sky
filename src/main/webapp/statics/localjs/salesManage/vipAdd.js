
$(function(){
//返回
    $("#back").click(function(){
        window.location.href="/vip/vipManage";
    });
    vipName=$("#vipName");
    phone=  $("#phone");
    address=$("#address");



    vipName.on("blur",function() {
    var vipTest=/^[A-Za-z0-9\u4e00-\u9fa5]{4,6}$/;
        if (vipTest.test(vipName.val())) {
            validateTip($("#nicheng"), {"color": "green"}, imgYes + "",true);
        } else {
            validateTip($("#nicheng"), {"color": "red"}, imgNo + " 昵称不能小于4位大于6位数！", false);

        }
    });




    phone.on("blur",function() {
        var testPhone=/^[1][3,4,5,7,8][0-9]{9}$/;
        if (phone.val().match(testPhone)) {
            validateTip($("#dianhua"), {"color": "green"}, imgYes + "", true);
        } else {
            validateTip($("#dianhua"), {"color": "red"}, imgNo + " 请输入正确的手机号！", false);
        }
    });

    address.on("blur",function() {
        if (address.val() != null && address.val() != "") {
            validateTip($("#dizhi"), {"color": "green"}, imgYes + "",true);
        } else {
            validateTip($("#dizhi"), {"color": "red"}, imgNo + " 请输入地址", false);

        }
    });
//保存,添加会员信息
$("#btn_add").click(function(){
    var vipLevel1=$("#vipLevel").val();
    var vipName1=jQuery("#vipName").val().trim();
    var sex1=$("#sex").val();
    var phone1=$("#phone").val();
    var address1=$("#address").val();
    vipName.blur();
    phone.blur();
    address.blur();
        if(vipName.attr("validateStatus") == "true"
            && phone.attr("validateStatus") == "true"
            &&address.attr("validateStatus") == "true"
           ) {
            jQuery.ajax({
                url: '/vip/addVip',//服务器端请求地址
                type: 'post',
                secureuri: false,//是否需要安全协议，一般设置为false
                contentType: 'application/json;charset=utf-8',
                dataType: 'json',//返回之类型一般设置为json
                data: JSON.stringify({
                    "vipLevel": vipLevel1,
                    "vipName": vipName1,
                    "sex": sex1,
                    "phone": phone1,
                    "address": address1
                }),
                success: function (result) {
                    console.log(result);
                    if (200 == result.status) {
                        alert("保存成功");
                        window.location.href = "/vip/vipManage";
                    } else {
                        /* $("#AddError").html(result.msg);*/
                        alert("保存失败！");
                    }
                }
            });
        }
});

});