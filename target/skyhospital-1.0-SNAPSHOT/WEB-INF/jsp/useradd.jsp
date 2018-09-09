
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>

    <base href="<%=basePath%>">

    <title>用户添加</title>
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

    <style>
        .form1 select,input{
            width: 200px;
        }
    </style>


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
            <h3>用户添加</h3>
        </div>


        <!--表单-->
        <div id="contentwrapper" class="contentwrapper">
            <div class="subcontent" id="validation">
                <form id="form1" class="stdform" method="post" action="" novalidate="novalidate">
                    <p>
                        <label>用户名</label>
                        <span class="field"><input type="text" name="UName" id="UName" class="longinput"> <font color="red">*</font></span>
                    </p>

                    <p>
                        <label>性别</label>
                        <span class="field">
                            <select name="Sex" id="Sex">
                                <option value="0" selected="selected">男</option>
                                <option value="1">女</option>
                            </select> <font color="red">*</font>
                        </span>
                    </p>

                    <p>
                        <label>出生日期</label>
                        <span class="field">
                            <input type="text" class="longinput" name="BortDate" id="BortDate" readonly="readonly" onclick="WdatePicker()" /> <font color="red">*</font>
                        </span>
                    </p>

                    <p>
                        <label>用户角色</label>
                        <span class="field">
                            <select name="RID" id="RID">
                            	<option value="1">店长</option>
                                <option value="2">库存管理员</option>
                                <option value="3">销售管理员</option>
                                <option value="4">采购管理员</option>
                                <option value="5" selected="selected">销售员</option>
                            </select> <font color="red">*</font>
                        </span>
                    </p>

                    <p>
                        <label>电话号码</label>
                        <span class="field">
                            <input type="text" name="Phone" id="Phone" class="longinput">
                            <font color="red">*</font>
                        </span>
                    </p>

                    <p>
                        <label>所在地</label>
                        <span class="field"><input type="text" name="Address" id="Address" class="longinput"></span>
                    </p>

                    <p>
                        <label>邮箱</label>
                        <span class="field">
                            <input type="text" name="email" id="email" class="longinput">
                            <font color="red">*</font>
                        </span>
                    </p>

                    <p>
                    <div class="item form-group">
                        <input type="hidden" id="errorinfo" value="" />
                        <label>个人证件照</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="file" name="Photo" required="required" id="Photo"/>
                            <font id="Photo"></font>
                        </div>
                    </p>

                    <!--按钮-->
                    <p class="stdformbutton">
                        <button class="submit radius2">保&nbsp;&nbsp;&nbsp;&nbsp;存</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button class="submit radius2">返&nbsp;&nbsp;&nbsp;&nbsp;回</button>
                    </p>
                </form>
            </div>
        </div>



    </div><!-- centercontent -->


</div><!--bodywrapper-->

</body>
</html>
