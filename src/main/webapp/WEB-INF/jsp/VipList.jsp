
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>会员管理列表</title>
    <link rel="stylesheet" href="statics/css/style.default.css" type="text/css" />
    <script type="text/javascript" src="statics/js/plugins/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.cookie.js"></script>
   <%-- <script type="text/javascript" src="statics/js/plugins/jquery.dataTables.min.js"></script>--%>
    <script type="text/javascript" src="statics/js/plugins/jquery.uniform.min.js"></script>
   <%-- <script type="text/javascript" src="statics/js/custom/general.js"></script>--%>
    <%--<script type="text/javascript" src="statics/js/custom/tables.js"></script>--%>
    <script type="text/javascript" src="statics/localjs/salesManage/vipList.js"></script>
    <%--获取路径上的信息--%>
    <script src="statics/localjs/salesManage/lujing.js"></script>

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


            <br clear="all" />


            <div class="contenttitle2">

                <h3 >会员管理列表</h3>
            </div><!--contenttitle vipAdd-->
            <div class="tableoptions" style="position: relative;">
                <button class="deletebutton radius3" title="table2" onclick="delVips();" >删除多个会员</button> &nbsp;
                <a href="vip/vipAdd" class="btn btn2 btn_book"><span>添加会员</span></a>
                <div style="position: absolute; top: 7px; right: 8px;">
                    <label >ID:
                        <input type="text" placeholder="请输入会员ID" id="vipId" value="" class="vip"
                               style="border: 1px solid #ddd; padding: 7px 5px 8px 5px; width: 200px; background: #fff;">
                        电话：<input type="text" placeholder="请输入会员电话号码" id="phone" value="" class="phone"
                               style="border: 1px solid #ddd; padding: 7px 5px 8px 5px; width: 200px; background: #fff;">
                        <a href="javascript:;" class="btn btn_search radius50" id="btn_query"><span>搜索</span></a>
                    </label>
                </div>
            </div><!--tableoptions-->
            <table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
                <colgroup>
                    <col class="con0" style="width: 4%" />
                    <col class="con1" />
                    <col class="con0" />
                    <col class="con1" />
                    <col class="con0" />
                    <col class="con1" />
                    <col class="con0" />
                </colgroup>
                <thead>
                <tr>
                    <th class="head0"><div class="" id="uniform-undefined"><span><input type="checkbox" class=""  id="allAndNotAll" ></span></div></th>
                    <th class="head1 sorting">会员ID</th>
                    <th class="head1 sorting">会员等级</th>
                    <th class="head0 sorting">会员姓名</th>
                    <th class="head1 sorting">积分</th>
                    <th class="head0 sorting">电话号码</th>
                    <th class="head1 sorting">详细地址</th>
                    <th class="head0 sorting">操作</th>
                </tr>
                </thead>

                <tbody id="vipInfoPage">

                </tbody>
            </table>

            <input type="hidden" id="hid_pageIndex" value="1">
            <input type="hidden" id="hid_totalPageCount" value="1">

            <div class="dataTables_paginate paging_full_numbers" id="dyntable_paginate" style="position: relative">
                <div class="dataTables_info" id="">
                    共<span id="pageCount">0</span>条记录
                    <span id="pageIndex">0</span>/<span id="totalPageCount">0</span>页
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


        </div><!--contentwrapper-->

    </div><!-- centercontent -->


</div><!--bodywrapper-->


</body>
</html>
