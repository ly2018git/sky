
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>药品字典列表显示</title>
    <script type="text/javascript" src="statics/js/plugins/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.uniform.min.js"></script>
    <!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="statics/css/style.ie9.css"/>
    <![endif]-->
    <!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="statics/css/style.ie8.css"/>
    <![endif]-->
    <!--[if lt IE 9]>
    <script src="statics/js/plugins/css3-mediaqueries.js"></script>
    <![endif]-->
    <script type="text/javascript" src="statics/localjs/salesManage/showdictionaries.js"></script>
</head>

<body class="withvernav">
<div class="bodywrapper">
    <jsp:include page="common/head.jsp"/>

    <div class="vernav2 iconmenu">
        <jsp:include page="common/leftmenu.jsp"/>
    </div><!--leftmenu-->

    <div id="contentwrapper" class="contentwrapper">
        <div class="centercontent tables">
            <div class="contenttitle2">
                <h3>药品字典列表</h3>
            </div><!--contenttitle-->

            <div class="dataTables_wrapper" id="dyntable2_wrapper">
                <div class="dataTables_filter" id="dyntable2_filter">
                    <label>药品名 : <input type="text" id="medicineName" placeholder="按下回车搜索"/></label>
                </div>

                <table cellpadding="0" cellspacing="0" border="0" id="table1" class="stdtable stdtablecb">
                    <div id="dyntable2_length" class="dataTables_length">
                        <label>显示
                            <select size="1" name="dyntable2_length" id="showline" onchange="showDictionaries(1)">
                                <option value="5" selected="selected">5</option>
                                <option value="10">10</option>
                                <option value="20">20</option>
                                <option value="50">50</option>
                            </select> 行
                        </label>
                    </div>
                    <thead>
                    <tr>
                        <th>ID码</th>
                        <th>药品名</th>
                        <th>通用名</th>
                        <th>规格</th>
                        <th>厂家</th>
                        <th>剂型</th>
                        <th>药品分类</th>
                        <th>自定义类</th>
                        <th>批准问号</th>
                    </tr>
                    </thead>
                    <tbody id="showdictionaries">
                    </tbody>
                </table>
                <jsp:include page="common/pageCommon.jsp"/>
                <%--<input type="hidden" id="hid_pageIndex" value="1"/>
                <input type="hidden" id="hid_totalPageCount" value="1"/>
                <div class="dataTables_info" id="dyntable2_info">共<span id="pageCount"></span>行</div>
                <div class="dataTables_paginate paging_full_numbers" id="dyntable2_paginate">
                    <a id="homePage" href="#"><span class="first paginate_button paginate_button_disabled">首页</span></a>
                    <a id="prevPage" href="#"><span class="previous paginate_button paginate_button_disabled">上一页</span></a>
                    <a id="nextPage" href="#"><span class="next paginate_button">下一页</span></a>
                    <a id="endPage" href="#"><span class="last paginate_button">末页</span></a>
                </div>--%>
            </div>

        </div><!-- centercontent -->
    </div><!--contentwrapper-->
</div><!--bodywrapper-->

</body>
</html>
