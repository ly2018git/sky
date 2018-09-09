<%--
  Created by IntelliJ IDEA.
  User: 12157
  Date: 2018/8/27
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="hidden" id="hid_pageIndex" value="1">
<input type="hidden" id="hid_totalPageCount" value="1">

<div class="dataTables_paginate paging_full_numbers" id="dyntable_paginate" style="position: relative">
    <div class="dataTables_info" id="">
        共<span id="pageCount">0</span>条记录
        <span id="pageIndex">0</span>/<span id="totalPageCount">0</span> 页
    </div>
    <span class="paginate_button paginate_button_disabled"><a href="javascript:;" id="homePage"
                                                              style="text-decoration: none">首页</a></span>
    <span class="paginate_button paginate_button_disabled"><a href="javascript:;" id="prevPage"
                                                              style="text-decoration: none">上一页</a></span>
    <%--<span class="paginate_active">1</span>--%>
    <%--输入--%>
    <span class="page-go-form">
                     <span class="paginate_button"><label>跳转至</label></span>
                <input type="text" name="inputPage" id="inputPage" class="page-key"/> 页
                <span class="paginate_button" id="page-btn"
                      onClick='jump_to(document.getElementById("inputPage").value)'>GO</span>
                </span>
    <%--end--%>
    <span class="paginate_button"><a href="javascript:;" id="nextPage" style="text-decoration: none">下一页</a></span>
    <span class="paginate_button"><a href="javascript:;" id="endPage" style="text-decoration: none">末页</a> </span>

</div>
</body>
</html>
