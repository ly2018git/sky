<%--
  Created by IntelliJ IDEA.
  User: 12157
  Date: 2018/8/21
  Time: 17:45
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
    <title>收银员交班</title>

    <script type="text/javascript" src="statics/js/plugins/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.uniform.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.smartWizard-2.0.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.colorbox-min.js"></script>
<%--测试验证--%>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/common.js"></script>

    <script type="text/javascript" src="statics/localjs/salesManage/shiftAdd.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function(){
            // Smart Wizard
            jQuery('#wizard').smartWizard({onFinish: onFinishCallback});
            jQuery('#wizard2').smartWizard({onFinish: onFinishCallback});
            jQuery('#wizard3').smartWizard({onFinish: onFinishCallback});
            jQuery('#wizard4').smartWizard({onFinish: onFinishCallback});

            function onFinishCallback(){
                alert('Finish Clicked');
            }

            jQuery(".inline").colorbox({inline:true, width: '60%', height: '500px'});

            jQuery('select, input:checkbox').uniform();
        });
    </script>
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
    <%--头部公共页面--%>
    <jsp:include page="common/head.jsp"/>
    <%--左边菜单栏页面--%>
    <div class="vernav2 iconmenu">
        <jsp:include page="common/leftmenu.jsp"/>
    </div><!--leftmenu-->

    <div class="centercontent">

        <div class="pageheader">
            <h1 class="pagetitle">收银员交班</h1>
            <ul class="hornav">
                <li class="current"><a href="#default">Default</a></li>
            </ul>
        </div><!--pageheader-->

        <div id="contentwrapper" class="contentwrapper">

            <div id="default" class="subcontent">
                <!-- START OF DEFAULT WIZARD -->
                <form class="stdform" method="post" action="">
                    <div id="wizard" class="wizard">
                        <br />
                        <br clear="all" />
                        <div class="stepContainer" style="height: 234px;"><div id="wiz1step1" class="formwiz content" style="display: block;">

                            <p>
                                <label>钱箱金额</label>
                                <span class="field"><input type="text" name="firstname" id="money" class="mediuminput"><b color="red" id="jiner"></b></span>
                            </p>

                            <p>
                                <label>钱箱金额说明</label>
                                <span class="field"><input type="text" name="lastname" id="comment" class="mediuminput"><b color="red" id="shuoming"></b></span>
                            </p>

                        </div>
                        </div>

                        <div class="actionBar"><a href="javascript:;" class="buttonFinish buttonDisabled" id="back">取消</a><a href="javascript:;" class="buttonNext" id="btn_add">完成</a></div>

                    </div><!--#wizard-->
                </form>
                <!-- END OF DEFAULT WIZARD -->

                <br /><br />

            </div><!-- #default -->


        </div><!--contentwrapper-->

    </div><!-- centercontent -->


</div><!--bodywrapper-->

</body>
</html>
