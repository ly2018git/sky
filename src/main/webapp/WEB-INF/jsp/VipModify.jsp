<%--
  Created by IntelliJ IDEA.
  User: 12157
  Date: 2018/8/22
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>会员修改</title>
    <script type="text/javascript" src="statics/js/plugins/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.uniform.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.validate.min.js"></script>
    <%-- <script type="text/javascript" src="statics/js/plugins/jquery.tagsinput.min.js"></script>--%>
    <%-- <script type="text/javascript" src="statics/js/plugins/charCount.js"></script>--%>
    <%--<script type="text/javascript" src="statics/js/plugins/ui.spinner.min.js"></script>--%>
    <script type="text/javascript" src="statics/js/plugins/chosen.jquery.min.js"></script>
    <%--<script type="text/javascript" src="statics/js/custom/general.js"></script>--%>
    <%-- <script type="text/javascript" src="statics/js/custom/forms.js"></script>--%>

    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/common.js"></script>
    <script type="text/javascript" src="statics/localjs/salesManage/vipModify.js"></script>

    <!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="statics/css/style.ie9.css"/>
    <![endif]-->
    <!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="statics/css/style.ie8.css"/>
    <![endif]-->
    <!--[if lt IE 9]>
    <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
    <%--获取路径上的信息--%>
    <script src="statics/localjs/salesManage/lujing.js"></script>

    <style type="text/css">
        /*提交按钮样式*/
        #btn_modify { border: 1px solid #f0882c; background: #fb9337; color: #fff; cursor: pointer; padding: 7px 10px; font-weight: bold; }
        input.buttons:hover { background: #485B79; border: 1px solid #3f526f; color: #fff; }
    /*取消按钮样式*/
        #back {
            width: auto; margin: 0; font-weight: bold; color: #666; border: 1px solid #ccc; background: #eee; padding: 7px 10px;
            -moz-box-shadow: none; -webkit-box-shadow: none; box-shadow: none; margin-left: 5px; -moz-border-radius: 2px; -webkit-border-radius: 2px;
            border-radius: 2px;
        }
        #back:hover { background: #ddd; cursor: pointer; color: #333; }
    </style>


</head>

<body class="withvernav">

<div class="bodywrapper">
    <%--头部公共页面--%>
    <jsp:include page="common/head.jsp"/>
    <%--左边菜单栏页面--%>
    <div class="vernav2 iconmenu">
        <jsp:include page="common/leftmenu.jsp"/>
    </div><!--leftmenu-->

    <div class="centercontent">

        <div id="contentwrapper" class="contentwrapper">

            <div id="basicform" class="subcontent">

                <div class="contenttitle2">
                    <h3>会员修改</h3>
                </div><!--contenttitle-->
                <%--action="" method="post"--%>
                <form class="stdform" >
                    <input type="hidden" name="id" id="id" >
                    <p>
                        <label>会员昵称</label>
                        <span class="field"><input type="text" name="input1" class="smallinput" id="vipName"/><b color="red" id="nicheng"></b></span>
                    </p>
                    <p>
                        <label>会员等级</label>
                        <span class="field">
                            <select name="select" class="uniformselect" id="vipLevel">
                            	<option value="vip">vip</option>
                                <option value="vips">vips</option>
                            </select>
                            </span>

                    </p>
                    <p>
                        <label>性别</label>
                        <span class="field">
                            <select name="select" class="uniformselect" id="sex">
                            	<option value="0">男</option>
                                <option value="1">女</option>
                            </select>
                            </span>
                    </p>

                    <p>
                        <label>电话号码</label>
                        <span class="field"><input type="text" name="" class="mediuminput" id="phone"/><b color="red" id="dianhua"></b></span>
                    </p>

                    <p>
                        <label>所在地</label>
                        <span class="field"><input type="text" name="" class="longinput" id="address"/><b color="red" id="dizhi"></b></span>
                    </p>
                    <div id="AddError"></div>
                    <p class="stdformbutton">
                        <%-- <button class="submit radius2" id="btn_add">提交</button>--%>
                        <input type="button" class="buttons radius2" id="btn_modify" value="提交"/>
                        <input type="button" class="reset radius2" value="返回" id="back"/>
                    </p>
                </form>


            </div><!--subcontent-->

        </div><!--contentwrapper-->

    </div><!-- centercontent -->


</div><!--bodywrapper-->

</body>
</html>
