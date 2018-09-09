<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>登录页面</title>
    <link rel="stylesheet" href="statics/css/style.default.css" type="text/css"/>
    <script type="text/javascript" src="statics/js/plugins/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.uniform.min.js"></script>
    <script type="text/javascript" src="statics/js/custom/general.js"></script>
    <script type="text/javascript" src="statics/js/custom/index.js"></script>
    <!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="statics/css/style.ie9.css"/>
    <![endif]-->
    <!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="statics/css/style.ie8.css"/>
    <![endif]-->
    <!--[if lt IE 9]>
    <script src="statics/js/plugins/css3-mediaqueries.js"></script>
    <![endif]-->
</head>
<body class="loginpage" style="background: #32415a url(/statics/images/patternbg.png);">
<div class="loginbox" style="box-shadow: 0 0 0 rgba(0,0,0,0);background: #32415a url(/statics/images/patternbg.png);">
    <div class="loginboxinner" style="padding: 20px;background: #32415a url(/statics/images/patternbg.png);">

        <div class="logo">
            <h1 class="logo">SkyHospital<%--.<span>Admin</span>--%></h1>
            <span class="slogan">后台管理系统</span>
        </div><!--logo-->

        <%--<br clear="all"/>--%>
        <!-- 消息提示 -->
        <div class="" id="loginmsg" style="color: red;text-align: center;font-size: 16px;"></div>
        <%--<span class="loginmsg" id="loginmsg"></span>--%>

        <form id="login" action="" method="post" style="margin: 0;">

            <!--用户名（登录名）-->
            <div class="username">
                <div class="usernameinner">
                    <input type="text" name="username" id="username" style="width: 263px;"/>
                </div>
            </div>


            <!--密码-->
            <div class="password">
                <div class="passwordinner">
                    <input type="password" name="password" id="password"/>
                </div>
            </div>

            <!--验证码-->
            <div class="code" style="background: #eee url(../statics/images/icons/mail.png) no-repeat 15px center">
                <div class="passwordinner">
                    <input type="text" name="code" id="code" placeholder="VerificationCode"/>
                </div>
            </div>
            <div class="code" style="">
                <div>
                    <img data-th-src="@{/getVerifyCode}" style="display: block; float: left;" id="Img"
                         onclick="changeCode()">
                </div>
            </div>
            <!-- 验证码end... -->


            <button type="button" id="success">登录</button>

            <%--<div class="keep"><input type="checkbox"/> 记住密码</div>--%>
        </form>

    </div><!--loginboxinner-->
</div><!--loginbox-->
</body>
<script type="text/javascript" src="statics/localjs/login.js"></script>

</html>
