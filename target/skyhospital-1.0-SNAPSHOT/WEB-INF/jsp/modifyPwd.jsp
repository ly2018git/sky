<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>

    <base href="<%=basePath%>">

    <title>修改密码</title>
    <%--<link rel="stylesheet" href="statics/css/style.default.css" type="text/css" />--%>
    <script type="text/javascript" src="statics/js/plugins/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.uniform.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.smartWizard-2.0.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.colorbox-min.js"></script>
    <%--<script type="text/javascript" src="statics/js/custom/general.js"></script>--%>
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
<body class="withvernav">
<div class="bodywrapper">
    <!-- 顶部 -->
    <jsp:include page="common/head.jsp"/>

    <!-- 左侧菜单 -->
    <div class="vernav2 iconmenu">
        <jsp:include page="common/leftmenu.jsp"/>
    </div><!--leftmenu-->

    <div class="centercontent" style="padding: 20px;">

        <div id="contentwrapper" class="contentwrapper">
            <div id="default" class="subcontent" style="display: block;">
                <!-- START OF DEFAULT WIZARD -->
                <form class="stdform" method="post" action="">
                    <div id="wizard" class="wizard">
                        <br>
                        <!-- 步骤：第一、二、三步 -->
                        <ul class="hormenu anchor">
                            <li>
                                <a href="javascript:;" class="selected" isdone="1" rel="1">
                                    <span class="h2">第一步</span>
                                    <span class="dot"><span></span></span>
                                    <span class="label">输入旧密码</span>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:;" class="done" isdone="1" rel="2">
                                    <span class="h2">第二步</span>
                                    <span class="dot"><span></span></span>
                                    <span class="label">输入新密码</span>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:;" class="done" isdone="1" rel="3">
                                    <span class="h2">第三步</span>
                                    <span class="dot"><span></span></span>
                                    <span class="label">确认修改</span>
                                </a>
                            </li>
                        </ul>
                        <br clear="all">
                        <br>
                        <br>

                        <!-- wiz1step1 -->
                        <!-- wiz1step2 -->
                        <!-- wiz1step3 -->
                        <div class="stepContainer" style="height: 238px;">
                            <!-- 第一步 -->
                            <div id="wiz1step1" class="formwiz content" style="display: block;">
                               <h4>第一步: 输入旧密码</h4>

                                <p>
                                    <label>旧密码</label>
                                    <span class="field">
                                        <input type="password" name="oldpwd" id="oldpwd" class="longinput">
                                        <font color="red" id="loginmsg"></font>
                                    </span>
                                </p>
                            </div>

                            <!-- 第二步 -->
                            <div id="wiz1step2" class="formwiz content" style="display: none;">
                                <h4>第二步: 输入新密码</h4>

                                <p>
                                    <label>新密码</label>
                                    <span class="field">
                                        <input type="password" name="newPwd" id="newPwd" class="longinput">
                                        <font color="red" id="longinput"></font>
                                    </span>
                                </p>
                                <p>
                                    <label>确认密码</label>
                                    <span class="field">
                                        <input type="password" name="reNewPwd" id="reNewPwd" class="longinput">
                                        <font color="red" id="longinputs"></font>
                                    </span>
                                </p>
                            </div>

                            <!-- 第三步 -->
                            <div id="wiz1step3" class="content" style="display: none;">
                                <h4>第三步: 确认修改</h4>
                                <img src="statics/images/timg.jpg"/>
                                <font id="succeed"></font>
                            </div>
                        </div>

                        <!-- 按钮 -->
                        <div class="actionBar">
                            <div class="loader">Loading</div>
                            <a href="#" class="buttonFinish">完成</a>
                            <a href="javascript:;" class="buttonNext" id="buttonNext" style="display: block;">下一步</a>
                        </div>

                    </div>
                </form>
            </div>
        </div>


    </div><!-- centercontent -->


</div><!--bodywrapper-->

</body>
<script type="text/javascript" src="statics/localjs/pwdmodify.js"></script>
</html>
