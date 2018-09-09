$(function () {
    var newpwd = null;
    var rnewpwd = null;
    $("#loginmsg").html("*");

    var cookieValue = jQuery.cookie("userName");
    var id = getCookie("userName", "UID");//拿到当前登录的用户的id

    jQuery("#oldpwd").blur(function () {
        var oldpwd = jQuery("#oldpwd").val().trim();
        console.log(id);
        console.log(oldpwd);

        $.ajax({
            type: "POST",
            url: "/user/pwdView",
            data: {oldpwd: oldpwd, UId: id},
            dataType: "json",
            success: function (result) {
                //console.log(result);
                if (200 == result.status) {
                    jQuery("#loginmsg").html(result.msg);
                    $('#loginmsg').css({'color':'green','font-weight':'bold','font-size':'16px'});
                } else {
                    jQuery("#loginmsg").html(result.msg);
                    $('#loginmsg').css('color', 'red');
                }
            },
        });
    }).on("focus", function () {
        $("#loginmsg").html("请输入原密码");
        $('#loginmsg').css('color', 'grey');
    });


    jQuery("#newPwd").focus(function () {
        $("#longinput").html("请输入新密码");
        $('#longinput').css('color', 'grey');
    }).on("blur", function () {
        newpwd = $("#newPwd").val().trim();
        console.log(newpwd);
        if (newpwd != null && newpwd != "") {
            //console.log(newpwd);
            if (newpwd.length > 6 && newpwd.length < 20) {
                $('#longinput').css({'color':'green','font-weight':'bold','font-size':'16px'});
                $("#longinput").html("✔");
            } else {
                $('#longinput').css('color', 'red');
                $("#longinput").html("✘密码为大于6小于20的字符");
            }
        } else {
            $('#longinput').css('color', 'red');
            $("#longinput").html("✘新密码不能为空");
        }
    });


    jQuery("#reNewPwd").focus(function () {
        $('#longinputs').css('color', 'grey');
        $("#longinputs").html("请确认新密码");
    }).on("blur", function () {
        rnewpwd = $("#reNewPwd").val().trim();
        console.log(rnewpwd);
        if (rnewpwd != null && rnewpwd != "") {
            //console.log(rnewpwd);
            if (rnewpwd == newpwd) {
                $("#longinputs").html("✔");
                $('#longinputs').css({'color':'green','font-weight':'bold','font-size':'16px'});
            } else {
                $('#longinputs').css('color', 'red');
                $("#longinputs").html("✘两次密码不一致");
            }
        } else {
            $('#longinputs').css('color', 'red');
            $("#longinputs").html("✘确认新密码不能为空");
        }
    });

    var count = 1;
    jQuery(".buttonNext").click(function () {
        if (count == 1) {
            count = count + 1;
            var restore = document.getElementById("wiz1step2");
            restore.style.display = "block";
            var restore = document.getElementById("wiz1step1");
            restore.style.display = "none";

        } else {
            var restore = document.getElementById("wiz1step2");
            restore.style.display = "none";
            console.log(rnewpwd);
            $.ajax({
                type: "POST",
                url: "/user/pwdModify",
                data: {rnewpwd: rnewpwd, UId: id},
                dataType: "json",
                success: function (result) {
                    //console.log(result);
                    if (200 == result.status) {
                        var restore = document.getElementById("buttonNext");
                        restore.style.display = "none";
                        var restore = document.getElementById("wiz1step3");
                        restore.style.display = "block";
                        jQuery.cookie("userName", "", {path: '/'});
                    } else {
                        $('#succeed').css('color', 'red');
                        jQuery("#succeed").html(result.msg);
                    }
                },
            });
        }
    });
});