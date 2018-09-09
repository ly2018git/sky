
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>药品销售列表</title>
    <link rel="stylesheet" href="statics/css/style.default.css" type="text/css" />
    <script type="text/javascript" src="statics/js/plugins/jquery-1.7.min.js"></script>

    <script type="text/javascript" src="statics/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.uniform.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.dataTables.min.js"></script>
    <%--  <script type="text/javascript" src="statics/js/custom/general.js"></script>--%>
    <%--时间--%>
    <script type="text/javascript" src="statics/js/calendar/WdatePicker.js"></script>

    <script type="text/javascript" src="statics/localjs/salesManage/sellItemList.js"></script>
    <!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="statics/css/style.ie9.css"/>
    <![endif]-->
    <!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="statics/css/style.ie8.css"/>
    <![endif]-->
    <!--[if lt IE 9]>
    <script src="statics/js/plugins/css3-mediaqueries.js"></script>
    <![endif]-->
    <link rel="stylesheet" media="screen" href="statics/localcss/commonpage.css"/>
</head>
<body class="withvernav">
<div class="bodywrapper">
    <%--头部公共页面--%>
    <jsp:include page="common/head.jsp"/>
    <%--左边菜单栏页面--%>
    <div class="vernav2 iconmenu">
        <jsp:include page="common/leftmenu.jsp"/>
    </div><!--leftmenu-->

    <div class="centercontent tables">

        <div id="contentwrapper" class="contentwrapper">
            <div class="contenttitle2">
                <h3>药品销售列表</h3>
            </div>
            <%--第一个--%>
                <div class="dataTables_wrapper" id="dyntable_wrapper">
                    <%--时间--%>
                        <div class="overviewhead">
                            From: &nbsp;<input type="text" id="sellDate1"
                                               class="hasDatepicker"
                                               onfocus="WdatePicker({maxDate:'%y-%M-%d'})">
                            &nbsp; &nbsp;
                            To: &nbsp;<input type="text" id="sellDate2" class="hasDatepicker"
                                             onfocus="WdatePicker({maxDate:'%y-%M-%d'})">
                            <a href="sellAccountAdd" class="btn btn_book" id="addSellAccount"><span>添加销售药品</span></a>
                        </div>
                    <%--end--%>

                        <div style="position: absolute; top: 8px; right: 8px;">
                            <label >搜索:
                                <input type="text" placeholder="请输入药品名称" id="medicineName" value="" class=""
                                       style="border: 1px solid #ddd; padding: 7px 5px 8px 5px; width: 200px; background: #fff;">
                                <a href="javascript:;" class="btn btn_search radius50" id="btn_query"><span>搜索</span></a>
                                <%--<a href="" class="btn btn_orange btn_search radius50"><span>Search</span></a>--%>
                            </label>
                        </div>
                    <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="dyntable" style="font-size: 12px;" >
                        <colgroup>
                            <col class="con0">
                            <col class="con1">
                            <col class="con0">
                            <col class="con1">
                            <col class="con0">
                            <col class="con1">
                            <col class="con0">
                            <col class="con1">
                            <col class="con0">
                            <col class="con1">
                            <col class="con0">
                            <col class="con1">
                            <col class="con1">
                        </colgroup>
                    <thead>
                    <tr>
                        <th class="head0 sorting" rowspan="1" colspan="1">药品ID</th>
                        <th class="head1 sorting" rowspan="1" colspan="1" >商品名</th>
                        <th class="head0 sorting" rowspan="1" colspan="1" >通用名</th>
                        <th class="head1 sorting" rowspan="1" colspan="1" >规格</th>
                        <th class="head0 sorting" rowspan="1" colspan="1" >生产企业</th>
                        <th class="head0 sorting" rowspan="1" colspan="1" >标准</th>
                        <th class="head0 sorting" rowspan="1" colspan="1" style="width: 50px;">是否处方药</th>
                        <th class="head0 sorting" rowspan="1" colspan="1" style="width: 80px;">实际售价</th>
                        <th class="head0 sorting" rowspan="1" colspan="1" style="width: 50px;">数量</th>
                        <th class="head0 sorting" rowspan="1" colspan="1" style="width: 50px;">金额</th>
                        <th class="head0 sorting" rowspan="1" colspan="1" >说明</th>
                        <th class="head0 sorting" rowspan="1" colspan="1" style="width: 80px;">销售日期</th>
                    </tr>
                    </thead>
                    <tbody id="SellItemInfoPage">

                    </tbody>
                </table>



               <%--分页--%>
                <input type="hidden" id="hid_pageIndex" value="1">
            <input type="hidden" id="hid_totalPageCount" value="1">

            <div class="dataTables_paginate paging_full_numbers" id="dyntable_paginate" style="position: relative">
                <div class="dataTables_info" id="">
                    共<span id="pageCount">0</span>条记录
                    当前<span id="pageIndex">0</span>/<span id="totalPageCount">0</span>页
                </div>
                <span class="paginate_button paginate_button_disabled" ><a href="javascript:;"  id="homePage" style="text-decoration: none">首页</a></span>
                <span class="paginate_button paginate_button_disabled"><a href="javascript:;"  id="prevPage" style="text-decoration: none">上一页</a></span>
                <%--输入--%>
                <span class="page-go-form">
                     <span class="paginate_button"><label>跳转至</label></span>
                    <input type="text" name="inputPage" id="inputPage" class="page-key" />页
                    <span class="paginate_button" id="page-btn" onclick='jump_to(document.getElementById("inputPage").value)'>GO</span>
                    </span>
                <%--end--%>
                <span class="paginate_button"><a href="javascript:;"  id="nextPage" style="text-decoration: none">下一页</a></span>
                <span class="paginate_button"><a href="javascript:;"  id="endPage" style="text-decoration: none">末页</a> </span>
                </div>
            <br /><br />
        </div><!--contentwrapper-->

    </div><!-- centercontent -->


</div><!--bodywrapper-->


</body>
</html>
