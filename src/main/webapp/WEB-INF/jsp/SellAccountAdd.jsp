<%--
  Created by IntelliJ IDEA.
  User: 12157
  Date: 2018/8/21
  Time: 16:17
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
    <title>添加销售药品</title>
    <script type="text/javascript" src="statics/js/plugins/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.cookie.js"></script>
  <%--  <script type="text/javascript" src="statics/js/plugins/jquery.uniform.min.js"></script>--%>
    <script type="text/javascript" src="statics/js/plugins/jquery.validate.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.tagsinput.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/charCount.js"></script>
    <script type="text/javascript" src="statics/js/plugins/ui.spinner.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/chosen.jquery.min.js"></script>
<%--begin--%>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/common.js"></script>
    <script type="text/javascript" src="statics/localjs/salesManage/sellAccountAdd.js"></script>

    <%--end --%>
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

        #btn_add { border: 1px solid #f0882c; background: #fb9337; color: #fff; cursor: pointer; padding: 7px 10px; font-weight: bold; }
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



                <br />

                <div class="contenttitle2">
                    <h3>添加销售药品</h3>
                </div><!--contenttitle-->

                <form class="stdform stdform2" method="post" action="" id="formId">
                        <input type="hidden" value="" id="yUID"/>
                    <input type="hidden" value="" id="yUName"/>
                       <p>
                           <label>药品名称</label>
                           <input type="hidden" value="" id="guiNum"/>
                           <input type="hidden" value="" id="guitaiId"/>
                           <input type="hidden" value="" id="yaopinId"/>
                           <input type="hidden" value="" id="medicineName">
                           <span class="field"><select name="selection" id="medicineId">
                            	<option value="/" selected="selected">请选择</option>
                            </select>
                           <b color="red" id="mingcheng"></b>
                           </span>
                       </p>
                       <p>
                       <label>数量</label>
                       <span class="field"><input type="text" name="lastname" id="number" class="longinput" /> <b color="red" id="testGuiNum"></b></span>
                   </p>
                       <p>
                           <label>单价</label>
                           <input type="hidden" value="" id="yincanPrice"/>
                           <span class="field"><input type="text" name="lastname" id="SalePrice" class="longinput" readonly="readonly" /></span>
                       </p>

                    <p>
                        <label>会员ID</label>
                        <span class="field">
                            <input type="hidden" id="syintegral"/>
                            <input type="hidden" value="" id="getvipid"/>
                            <select name="selection" id="vipId">
                            	<option value="/" selected="selected">请选择</option>
                            </select>
                            <b color="red" id="huiyuanid"></b>
                        </span>
                    </p>
                    <p style="display: none" id="xuanze">
                        <label>选择优惠方式</label>
                        <span class="field">
                            <input type='radio' name='radiobutton' value='1' id='sel1' checked="checked"/><input type="text" name="lastname" id="banjia" class="longinput" readonly="readonly" value="半价优惠"/>
                            <input type='radio' name='radiobutton' value='2' id='sel2'/><input type="text" name="lastname" id="jifendikou" class="longinput" readonly="readonly" value="积分抵扣"/></span>
                    </p>
                    <p>
                        <label>销售总额</label>
                        <span class="field"><input type="text" name="lastname" id="Amount" class="longinput" readonly="readonly"/></span>
                    </p>
                    <p>
                        <label>实付金额</label>
                        <span class="field"><input type="text" name="lastname" id="ActuallyPaid" class="longinput" readonly="readonly"/></span>
                    </p>

                    <p>
                        <label>应付金额</label>
                        <span class="field"><input type="text" name="lastname" id="Due" class="longinput" readonly="readonly"/></span>
                    </p>
                    <p>
                        <label>减免金额</label>
                        <span class="field"><input type="text" name="lastname" id="CutAmount" class="longinput" readonly="readonly"/></span>
                    </p>
                    <p>
                        <label>减免说明</label>
                        <span class="field"><input type="text" name="lastname" id="CutComment" class="longinput" readonly="readonly"/></span>
                    </p>
                    <p>
                        <label>支付方式</label>
                        <span class="field">
                            <select name="selection" id="PayWay">
                            	<option value="">请选择</option>
                                <option value="现金">现金</option>
                                <option value="微信">微信</option>
                                <option value="支付宝">支付宝</option>
                                <option value="银行卡刷卡">银行卡刷卡</option>
                            </select>
                             <b color="red" id="zhifufangshi"></b>
                        </span>
                    </p>
                    <p>
                        <label>账单备注</label>
                        <span class="field">
                            <input type="text" name="lastname" id="comment" class="longinput" readonly="readonly"/>
                        </span>
                    </p>
                    <p>
                        <label>药品单位</label>
                        <span class="field">
                            <select name="selection" id="UnitName">
                            	<option value="">请选择</option>
                            </select>
                             <b color="red" id="danwei"></b>
                        </span>
                    </p>

                       <p class="stdformbutton">
                           <input type="button" class="buttons radius2" id="btn_add" value="提交"/>
                           <input type="button" class="reset radius2" value="完成" id="back" />
                       </p>
                </form>

                <br />

            </div><!--subcontent-->



        </div><!--contentwrapper-->

    </div><!-- centercontent -->


</div><!--bodywrapper-->

</body>
</html>
