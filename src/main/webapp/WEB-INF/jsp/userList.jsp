<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>

    <base href="<%=basePath%>">

    <title>人事列表</title>
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
    <!--[if lte IE 8]>
    <script language="javascript" type="text/javascript" src="statics/js/plugins/excanvas.min.js"></script><![endif]-->
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
            <h3>人事列表</h3>
        </div>

        <div class="dataTables_wrapper" id="dyntable_wrapper">

            <div id="dyntable_length" class="dataTables_length">
                <label style="display: block; height: 27px;">
                </label>
            </div>
            <div class="dataTables_filter" id="dyntable_filter">
                <label>搜索: <input type="text" placeholder="输入员工姓名"></label>
            </div>

            <!-- 表格 -->
            <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="dyntable" style="font-size: 12px;">
                <thead>
                <tr>
                    <th class="head0" style="width: 60px;">编号</th>
                    <th class="head1" style="width: 100px;">姓名</th>
                    <th class="head1" style="width: 50px;">性别</th>
                    <th class="head0" style="width: 120px;">电话</th>
                    <th class="head1" style="width: 120px;">角色</th>
                    <th class="head0" style="width: 220px;">地址</th>
                    <th class="head1">操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>12</td>
                    <td>欧瑞</td>
                    <td>男</td>
                    <td>18755744748</td>
                    <td>
                        <select>
                            <option value="1">店长</option>
                            <option value="2">库存管理员</option>
                            <option value="3" selected="selected">销售管理员</option>
                            <option value="4">采购管理员</option>
                            <option value="5">销售员</option>
                        </select>
                    </td>
                    <td>广州海珠区</td>
                    <td>
                        <button>修改角色</button>
                        <button>删除用户</button>
                    </td>
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
