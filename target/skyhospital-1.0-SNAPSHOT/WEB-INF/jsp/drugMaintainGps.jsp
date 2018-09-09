<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>药品养护报表</title>
    <%--<link rel="stylesheet" href="statics/css/style.default.css" type="text/css" />--%>
    <script type="text/javascript" src="statics/js/plugins/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.uniform.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.flot.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.flot.resize.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.slimscroll.js"></script>
     <%--<script type="text/javascript" src="statics/js/custom/general.js"></script>--%>
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


</head>
<body class="withvernav">
<div class="bodywrapper">
    <jsp:include page="common/head.jsp"/>

    <div class="vernav2 iconmenu">
        <jsp:include page="common/leftmenu.jsp"/>
    </div><!--leftmenu-->

    <div class="centercontent" style="padding: 20px;">
        <div class="pageheader" style=""></div><!--pageheader-->

        <div class="contenttitle2">
            <h3>药品养护</h3>
        </div>


        <div class="dataTables_wrapper" id="dyntable_wrapper">

            <div id="dyntable_length" class="dataTables_length">
                <label style="display: block; height: 27px;">
                </label>
            </div>
            <div class="dataTables_filter" id="dyntable_filter">
                <label>搜索: <input type="text" placeholder="请输入药品名称"></label>
            </div>

            <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="dyntable" style="font-size: 12px;">
                <thead>
                <tr>
                    <th class="head0">药品编号</th>
                    <th class="head1">药品名</th>
                    <th class="head0">通用名</th>
                    <th class="head1">规格</th>
                    <th class="head0">单位</th>
                    <th class="head1">批号</th>
                    <th class="head0">数量</th>
                    <th class="head1">厂家</th>
                    <th class="head0">有效期</th>
                    <th class="head1">剩余天数</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>盐酸特拉唑嗪胶囊</td>
                    <td>盐酸特拉唑嗪胶囊</td>
                    <td>颗粒剂</td>
                    <td>盒</td>
                    <td>SA201820</td>
                    <td>80</td>
                    <td>哈药集团制药总厂</td>
                    <td>2019-04-01</td>
                    <td>350</td>
                </tr>
                </tbody>
            </table>
        </div>

        <!-- 分页start... -->
        <jsp:include page="common/pageCommon.jsp"></jsp:include>
        <!-- 分页end... -->

    </div><!-- centercontent -->


</div><!--bodywrapper-->

</body>
</html>
