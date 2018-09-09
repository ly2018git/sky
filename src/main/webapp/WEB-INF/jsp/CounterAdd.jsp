<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>

    <base href="<%=basePath%>">
    <title>添加柜台销售药品</title>
    <script type="text/javascript" src="statics/js/plugins/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.uniform.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.validate.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/chosen.jquery.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/common.js"></script>
    <script type="text/javascript" src="statics/localjs/salesManage/counterAdd.js"></script>

    <!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="statics/css/style.ie9.css"/>
    <![endif]-->
    <!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="statics/css/style.ie8.css"/>
    <![endif]-->
    <!--[if lt IE 9]>
    <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->


    <style type="text/css">

        #addcounter { border: 1px solid #f0882c; background: #fb9337; color: #fff; cursor: pointer; padding: 7px 10px; font-weight: bold; }
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
                    <h3>添加柜台销售药品</h3>
                </div><!--contenttitle-->
                <%--action="" method="post"--%>
                <form class="stdform" >

                    <p>
                        <label>药品商用名称</label>
                        <span class="field">
                            <input type="hidden" value="" id="yaopinId"/>
                            <select name="select" class="uniformselect" id="medicineId">
                            	<option value="" selected="selected">--请选择--</option>
                            </select>
                            <b color="red" id="mingcheng"></b>
                            </span>

                    </p>
                    <p>
                        <label>库存剩余数量</label>
                        <span class="field"><input type="text" name="" class="mediuminput" id="kucuns" readonly="readonly" value=""/><b color="red" id="kucunshuliang"></b></span>
                    </p>
                    <p>
                        <label>数量</label>
                        <input type="hidden" id="chaxunNum" value=""/>
                        <span class="field"><input type="text" name="" class="mediuminput" id="number"/><b color="red" id="shuliang"></b></span>
                    </p>

                    <p>
                        <label>存放货位</label>
                        <span class="field">
                            <select name="select" class="uniformselect" id="GAID">
                            	<option value="" selected="selected">--请选择--</option>
                            </select>
                            <b color="red" id="huowei"></b>
                            </span>
                    </p>

                    <div id="AddError"></div>
                    <p class="stdformbutton">
                        <input type="button" class="buttons radius2" id="addcounter" value="提交"/>
                        <input type="button" class="reset radius2" value="返回" id="back"/>
                    </p>
                </form>


            </div><!--subcontent-->

        </div><!--contentwrapper-->

    </div><!-- centercontent -->


</div><!--bodywrapper-->

</body>
</html>
