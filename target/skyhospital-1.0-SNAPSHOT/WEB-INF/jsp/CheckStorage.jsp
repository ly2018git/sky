
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>

    <base href="<%=basePath%>">

    <title>查询库存</title>
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
            <h3>查询库存</h3>
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
                    <th class="head0">药品ID</th>
                    <th class="head1">药品名</th>
                    <th class="head0">通用名</th>
                    <th class="head1">规格</th>
                    <th class="head0">货位</th>
                    <th class="head1">数量</th>
                    <th class="head0">入库日期</th>
                    <th class="head1">有效期</th>
                    <th class="head0">厂家</th>
                    <th class="head1">药品分类</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Trident</td>
                    <td>Internet Explorer 4.0</td>
                    <td>Win 95+</td>
                    <td class="center">4</td>
                    <td class="center">X</td>
                    <td>Trident</td>
                    <td>Internet Explorer 4.0</td>
                    <td>Win 95+</td>
                    <td class="center">4</td>
                    <td class="center">X</td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="dataTables_info" id="dyntable_info" style="bottom: 32px;left: 30px;">Showing 1 to 10 of 51 entries</div>
        <div class="dataTables_paginate paging_full_numbers" id="dyntable_paginate">
            <span class="first paginate_button paginate_button_disabled" id="dyntable_first">First</span>
            <span class="previous paginate_button paginate_button_disabled" id="dyntable_previous">Previous</span><span><span class="paginate_active">1</span>
            <span class="paginate_button">2</span><span class="paginate_button">3</span>
            <span class="paginate_button">4</span><span class="paginate_button">5</span>
        </span>
            <span class="next paginate_button" id="dyntable_next">Next</span>
            <span class="last paginate_button" id="dyntable_last">Last</span>
        </div>

    </div><!-- centercontent -->


</div><!--bodywrapper-->

</body>
</html>
