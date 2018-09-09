<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>左边菜单公共页面</title>

    <script type="text/javascript" src="statics/js/custom/general.js"></script>
    <link rel="stylesheet" href="statics/css/style.default.css" type="text/css"/>
    <script type="text/javascript" src="statics/js/plugins/jquery-1.7.min.js"></script>
    <script typt="text/javascript" src="statics/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="statics/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="statics/localjs/publicUtil.js"></script>
</head>
<body>
<ul>
    <li><a href="#formsub" class="editor">用户管理</a>
        <span class="arrow"></span>
        <ul id="formsub">
            <li><a href="/user/userinfo" id="userView">个人信息</a></li>
            <li><a href="/user/modifypwd">修改密码</a></li>
            <li><a href="/user/userlist">人事列表</a></li>
            <li><a href="/user/useradd">添加用户</a></li>
            <li><a href="">权限管理</a></li>
        </ul>
    </li>
    <li><a href="#jiben" class="typo">基本信息</a>
        <span class="arrow"></span>
        <ul id="jiben">
            <li><a href="">药品字典</a></li>
            <li><a href="vipManage">会员管理</a></li>
            <li><a href="">买家管理</a></li>
        </ul>
    </li>
    <!--<li><a href="filemanager.html" class="gallery">文件管理</a></li>-->
    <li><a href="#tonji" class="elements">统计查询</a>
        <span class="arrow"></span>
        <ul id="tonji">
            <li><a href="checkStorage">查询库存</a></li>
            <li><a href="">查询销售记录</a></li>
            <li><a href="">查询交班记录</a></li>
            <li><a href="">查询入库记录</a></li>
            <li><a href="">查询出库记录</a></li>
        </ul>
    </li>
    <li><a href="#kucun" class="support">库存管理</a>
        <span class="arrow"></span>
        <ul id="kucun">
            <li><a href="">库存盘点</a></li>
            <li><a href="">调价促销</a></li>
            <li><a href="">有效期报警</a></li>
            <li><a href="">药品处理</a></li>
        </ul>
    </li>
    <li><a href="#salesManage" class="widgets">销售业务</a>
        <span class="arrow"></span>
        <ul id="salesManage">
            <li><a href="sellItem">药品销售</a></li>
            <li><a href="">销售药品添加</a></li>
            <li><a href="sellAccount">销售营业额</a></li>
            <li><a href="">销售员交班</a></li>
            <li><a href="">柜台药品销售计划</a></li>
        </ul>
    </li>
    <li><a href="#caigou" class="calendar">采购业务</a>
        <span class="arrow"></span>
        <ul id="caigou">
            <li><a href="">药品添加</a></li>
            <li><a href="">药品入库</a></li>
            <li><a href="">药品出库</a></li>
            <li><a href="">出入库审核</a></li>
        </ul>
    </li>
    <li><a href="#baobiao" class="tables">GPS报表</a>
        <span class="arrow"></span>
        <ul id="baobiao">
            <li><a href="/gps/drugPurchaseGps">药品购进记录报表</a></li>
            <li><a href="/gps/drugSalesGps">药品销售明细报表</a></li>
            <li><a href="/gps/drugMaintainGps">药品养护报表</a></li>
        </ul>
    </li>
    <%--<li><a href="buttons.html" class="buttons">客户支持</a></li>
    <li><a href="#error" class="error">错误页面</a>
        <span class="arrow"></span>
        <ul id="error">
            <li><a href="notfound.html">404错误页面</a></li>
            <li><a href="forbidden.html">403错误页面</a></li>
            <li><a href="internal.html">500错误页面</a></li>
            <li><a href="offline.html">503错误页面</a></li>
        </ul>
    </li>
    <li><a href="#addons" class="addons">其他页面</a>
        <span class="arrow"></span>
        <ul id="addons">
            <li><a href="newsfeed.html">新闻订阅</a></li>
            <li><a href="profile.html">资料页面</a></li>
            <li><a href="productlist.html">产品列表</a></li>
            <li><a href="photo.html">图片视频分享</a></li>
            <li><a href="gallery.html">相册</a></li>
            <li><a href="invoice.html">购物车</a></li>
        </ul>
    </li>--%>
</ul>
<a class="togglemenu"></a>
<br/><br/>
</body>
</html>
