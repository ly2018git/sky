<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>调价列表显示</title>
    <script type="text/javascript" src="statics/js/plugins/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="statics/js/plugins/jquery.uniform.min.js"></script>
    <script type="text/javascript" src="statics/js/calendar/WdatePicker.js"></script>

    <!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="statics/css/style.ie9.css"/>
    <![endif]-->
    <!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="statics/css/style.ie8.css"/>
    <![endif]-->
    <!--[if lt IE 9]>
    <script src="statics/js/plugins/css3-mediaqueries.js"></script>
    <![endif]-->
    <script type="text/javascript" src="statics/localjs/stockManage/showadjust.js"></script>
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
                <h3>调价促销列表</h3>
            </div><!--contenttitle-->

            <div class="dataTables_wrapper" id="dyntable2_wrapper">
                <div class="dataTables_filter" id="dyntable2_filter">
                    <select class="radius3" id="discount" style="vertical-align: center;margin-top: 2px">
                        <option value="0" selected="selected">-请选择折扣-</option>
                        <option value="0.5">5折</option>
                        <option value="0.6">6折</option>
                        <option value="0.7">7折</option>
                        <option value="0.8">8折</option>
                        <option value="0.9">9折</option>
                    </select>
                    <a id="changePrice" href="#" onclick="checkDiscount()" style=""><span class="first paginate_button paginate_button_disabled"><button>调价</button></span></a>
                    <label style="margin-left: 350px">
                        库存 :
                        <select class="radius3" id="number" style="margin-top: 2px">
                            <option value="" selected="selected">-请选择-</option>
                            <option value="0">0-100</option>
                            <option value="100">100-200</option>
                            <option value="200">200-300</option>
                            <option value="300">300-400</option>
                            <option value="400">400-500</option>
                            <option value="500">500-600</option>
                            <option value="600">600-700</option>
                            <option value="700">700-800</option>
                            <option value="800">800-900</option>
                            <option value="900">900-1000</option>
                            <option value="1000">1000+</option>
                        </select>
                    </label>&nbsp;&nbsp;&nbsp;
                    <label>
                        日期 :
                        <input type="text" onfocus="WdatePicker()" class="hasDatepicker" id="chooseDate"/>
                    </label>&nbsp;&nbsp;&nbsp;
                    <label>
                        药品名 :
                        <input type="text" id="medicineName"/>&nbsp;
                        <button type="button" onclick="showAdjust(1)">搜&nbsp;索</button>&nbsp;
                    </label>
                </div>

                <table cellpadding="0" cellspacing="0" border="0" id="table1" class="stdtable stdtablecb">
                    <div id="dyntable2_length" class="dataTables_length">
                        <label>显示
                            <select size="1" name="dyntable2_length" id="showline" onchange="showAdjust(1)">
                                <option value="5" selected="selected">5</option>
                                <option value="10">10</option>
                                <option value="20">20</option>
                                <option value="50">50</option>
                            </select> 行
                        </label>
                    </div>
                    <thead>
                    <tr>
                        <th><input id="checkAll" type="checkbox" class="checkall" style="width: 20px;"/></th>
                        <th>药品ID</th>
                        <th>药品名</th>
                        <th>厂家</th>
                        <th>规格</th>
                        <th>单位</th>
                        <th>库存量</th>
                        <th>批号</th>
                        <th>采购价</th>
                        <th>销售价</th>
                        <th>会员价</th>
                        <th>促销提成</th>
                        <th>货位</th>
                        <th>入库日期</th>
                        <th>有效期</th>
                        <th>剂型</th>
                    </tr>
                    </thead>
                    <tbody id="showadjustpage">
                    </tbody>
                </table>
                <jsp:include page="common/pageCommon.jsp"/>
               <%-- <input type="hidden" id="hid_pageIndex" value="1"/>
                <input type="hidden" id="hid_totalPageCount" value="1"/>
                <div class="dataTables_info" id="dyntable2_info">共<span id="pageCount"></span>行</div>
                <div class="dataTables_paginate paging_full_numbers" id="dyntable2_paginate">
                    <a id="homePage" href="#"><span class="first paginate_button paginate_button_disabled">首页</span></a>
                    <a id="prevPage" href="#"><span class="previous paginate_button paginate_button_disabled">上一页</span></a>
                    <a id="nextPage" href="#"><span class="next paginate_button" id="dyntable2_next">下一页</span></a>
                    <a id="endPage" href="#"><span class="last paginate_button" id="dyntable2_last">末页</span></a>
                </div>--%>
            </div>
        </div><!-- centercontent -->
    </div><!--contentwrapper-->
</div><!--bodywrapper-->
</body>
</html>
