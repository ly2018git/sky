<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>头部公共页面</title>
</head>
<body>
<div class="topheader">
    <div class="left">
        <h1 class="logo">SkyHospital.<span class="name"></span></h1>
        <span class="slogan">后台管理系统</span>

        <br clear="all"/>

    </div><!--left-->

    <div class="right">
        <!--<div class="notification">
            <a class="count" href="ajax/notifications.html"><span>9</span></a>
        </div>-->
        <div class="userinfo">
            <span class="userPhoto">
                <img src="statics/images/thumbs/avatar.png" alt=""/>
            </span>
            <span class="roles"></span>
        </div><!--userinfo-->

        <div class="userinfodrop">
            <div class="avatar">
                <a href="">
                    <img src="statics/images/thumbs/avatarbig.png" alt=""/>
                </a>
            </div><!--avatar-->
            <div class="userdata">
                <h4 class="name"></h4>&nbsp;
                <span class="email"></span>
                <ul>
                    <li><a href="/user/userinfo">编辑资料</a></li>
                    <%--<li><a href="">修改密码</a></li>--%>
                    <li><a href="javascript:;" id="exit">退出</a></li>
                </ul>
            </div><!--userdata-->
        </div><!--userinfodrop-->
    </div><!--right-->
</div><!--topheader-->


<div class="header">
    <ul class="headermenu">
        <li class="current">
            <a href="/welcome"><span class="icon icon-flatscreen"></span>首页</a>
        </li>
        <li>
            <a href="/user/userlist"><span class="icon icon-pencil"></span>用户管理</a>
        </li>
        <li>
            <a href="/user/userinfo"><span class="icon icon-message"></span>个人信息</a>
        </li>
        <li>
            <a href="/gps/drugPurchaseGps"><span class="icon icon-chart"></span>统计报表</a>
        </li>
    </ul>



</div><!--header-->
<%--引用公共js的界面--%>
<%@include file="js.jsp" %>
</body>
</html>
