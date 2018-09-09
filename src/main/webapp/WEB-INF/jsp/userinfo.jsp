
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>

    <base href="<%=basePath%>">

    <title>个人信息</title>
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

        #but_modify{
            width: 60px; border: 1px solid #f0882c;background: #fb9337;
            color: #fff;cursor: pointer;padding: 7px 10px;font-weight: bold;
        }

        #but_modify:hover{
            background: #485B79; border: 1px solid #3f526f; color: #fff;
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
            <h3>个人信息</h3>
        </div>

        <!--表单-->
        <div id="contentwrapper" class="contentwrapper">
            <div class="subcontent" id="validation">
                <form id="form1" class="stdform" method="post" action="" novalidate="novalidate">

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
                        <label>姓名</label>
                        <span class="field">
                            <input type="text" name="UName" id="UName" class="longinput" value="Juan">
                            <font color="red">*</font>
                        </span>
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
                        <label>电话号码</label>
                        <span class="field">
                            <input type="text" name="Phone" id="Phone" class="longinput" value="13778945844">
                            <font color="red">*</font>
                        </span>
                    </p>

                    <p>
                        <label>所在地</label>
                        <span class="field"><input type="text" name="Address" id="Address" class="longinput" value="广州海珠区8"></span>
                    </p>

                    <p>
                        <label>出生日期</label>
                        <span class="field">
                            <input type="text" class="longinput" name="BortDate" id="BortDate" readonly="readonly" value="1996-04-25" onclick="WdatePicker()" /> <font color="red">*</font>
                        </span>
                    </p>

                    <p>
                        <label>个人证件照</label>
                        <div id="uploadfile" style="display: none;">
                            <input id="attach"  type="file" class="" name="attach">
                        </div>
                        <div id="uploadfile2"></div>
                        <div id="logoFile"></div>
                        <span id="fileUploadError"></span>
                    </p>

                    <!--按钮-->
                    <p class="stdformbutton">
                        <%--<button class="submit radius2" id="modify">修&nbsp;&nbsp;&nbsp;&nbsp;改</button>--%>
                        <input type="button" id="but_modify" class="radius2" value="编&nbsp;&nbsp;&nbsp;&nbsp;辑"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button class="submit radius2" id="back">返&nbsp;&nbsp;&nbsp;&nbsp;回</button>
                    </p>
                </form>
            </div>
        </div>



    </div><!-- centercontent -->


</div><!--bodywrapper-->

</body>
</html>
