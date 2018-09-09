jQuery(function(){

    //返回到交班列表页面
    $("#back").click(function(){
        window.location.href="/vipManage";
    });

    money=$("#money");
    comment=$("#comment");



    money.on("blur",function() {
        var reg=/^\d+(\.\d{0,2})?$/;
        if (reg.test(money.val())) {
            validateTip($("#jiner"), {"color": "green"}, imgYes + "",true);
        } else {
            validateTip($("#jiner"), {"color": "red"}, imgNo + " 请输入正确的金额数！", false);

        }
    });




    comment.on("blur",function() {
        var testcomment=/^.{1,50}$/;
        if (testcomment.test(comment.val())) {
            validateTip($("#shuoming"), {"color": "green"}, imgYes + "", true);
        } else {
            validateTip($("#shuoming"), {"color": "red"}, imgNo + "请输入不超过50字的说明", false);
        }
    });




//保存,添加会员信息
    $("#btn_add").click(function(){
        var money1=$("#money").val();
        var comment1=jQuery("#comment").val().trim();
        money.blur();
        comment.blur();
        if(money.attr("validateStatus") == "true"
            && comment.attr("validateStatus") == "true"
        ) {
            jQuery.ajax({
                url: '/addShift',//服务器端请求地址
                type: 'post',
                secureuri: false,//是否需要安全协议，一般设置为false
                contentType: 'application/json;charset=utf-8',
                dataType: 'json',//返回之类型一般设置为json
                data: JSON.stringify({
                    "money": money1,
                    "comment": comment1,
                }),
                success: function (result) {
                    console.log(result);
                    if (200 == result.status) {
                        alert("保存成功");
                        window.location.href = "/vipManage";
                    } else {
                        alert("保存失败！");
                    }
                }
            });
        }
    });


});