
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>

    <base href="<%=basePath%>">

    <title>控制台页面(欢迎界面)</title>
    <%--<link rel="stylesheet" href="statics/css/style.default.css" type="text/css" />--%>
    <script type="text/javascript" src="statics/js/plugins/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.uniform.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.flot.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.flot.resize.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.slimscroll.js"></script>
   <%-- <script type="text/javascript" src="statics/js/custom/general.js"></script>--%>
    <script type="text/javascript" src="statics/js/custom/dashboard.js"></script>
    <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="statics/js/plugins/excanvas.min.js"></script><![endif]-->
    <!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="statics/css/style.ie9.css"/>
    <![endif]-->
    <!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="statics/css/style.ie8.css"/>
    <![endif]-->
    <!--[if lt IE 9]>
    <script src="statics/js/plugins/css3-mediaqueries.js"></script>
    <![endif]-->

    <style>
        .wColck {
            width: 88px;
            height: 108px;
            margin: 50px;
            float: left;
        }
        .wFont {
            float: left;
            margin-top: 50px;
        }
    </style>

</head>
<body class="withvernav">
<div class="bodywrapper">
<jsp:include page="common/head.jsp"/>

    <div class="vernav2 iconmenu">
    <jsp:include page="common/leftmenu.jsp"/>
    </div><!--leftmenu-->

    <div class="centercontent">

        <div class="pageheader">
            <img class="wColck" src="statics/images/clock.jpg" alt="" />
            <div class="wFont">
                <h1 class="pagetitle"><span class="name"></span>&nbsp;<span class="roles"></span></h1>
                <p style="font-size: 16px;margin-left: 1rem;">欢迎进入药房管理系统!</p>
            </div>
        </div><!--pageheader-->

        <br clear="all" />

    </div><!-- centercontent -->


</div><!--bodywrapper-->

</body>
</html>
