$(function () {
    //显示药品处理信息
    showDispose(1);

    /**
     * 首页
     */
    $("#homePage").click(function () {
        showDispose(1);
    });

    /**
     * 上一页
     */
    $("#prevPage").click(function () {
        var pageIndex = $("#hid_pageIndex").val();
        showDispose(pageIndex - 1 >= 1 ? pageIndex - 1 : 1);
    });

    /**
     * 下一页
     */
    $("#nextPage").click(function () {
        var pages = $("#hid_totalPageCount").val();
        var pageIndex = parseInt($("#hid_pageIndex").val());
        showDispose(pageIndex + 1 <= pages ? pageIndex + 1 : pages);
    });

    /**
     * 末页
     */
    $("#endPage").click(function () {
        var pages = $("#hid_totalPageCount").val();
        showDispose(pages);
    });

    /**
     * 按下回车执行模糊查询
     */
    $("#medicineName").keyup(function(){
        if(event.keyCode == 13){
            //显示药品处理信息
            showDispose(1);
        }
    });

});

/**
 * 分页输入框
 */
function jump_to(num){
    //alert(num);
    //验证用户的输入
    var regexp=/^[1-9]\d*$/;
    var totalPageCount = jQuery("#hid_totalPageCount").val();
    if(!regexp.test(num)){
        alert("请输入大于0的正整数！");
        return false;
    }else if((num-totalPageCount) > 0){
        alert("请输入小于总页数的页码");
        return false;
    }else{
        showDispose(num);
    }
}



/**
 * 显示药品处理信息列表
 * @param pageIndex
 */
function showDispose(pageIndex) {
    var pageSize=parseInt($("#showline").val());
    $.ajax({
        url: "/stock/showdisposelist",
        type: "POST",
        data: JSON.stringify({
            "pageSize": pageSize,
            "pageIndex": pageIndex
        }),
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function (result) {
            if (200 == result.status) {
                console.log(result);
                var pageStr = '';
                for (var i = 0; i < result.data.list.length; i++) {
                    pageStr += '<tr role="row" class="odd">' +
                        '<td>' + result.data.list[i].medicineId + '</td>' +
                        '<td>' + result.data.list[i].ioDate + '</td>' +
                        '<td>' + result.data.list[i].medicineName + '</td>' +
                        '<td>' + result.data.list[i].commonName + '</td>' +
                        '<td>' + result.data.list[i].specificationName + '</td>' +
                        '<td>' + result.data.list[i].unitName + '</td>' +
                        '<td>' + result.data.list[i].manufacturerName + '</td>' +
                        '<td>' + result.data.list[i].comment + '</td>' +
                        '<td>' + result.data.list[i].batchNumber + '</td>' +
                        '<td>' + result.data.list[i].validity + '</td>' +
                        '<td>' + result.data.list[i].number + '</td>' +
                        '<td>' + result.data.list[i].handling + '</td>' +
                        '<td>' + result.data.list[i].mComment + '</td>';
                    pageStr += '</td></tr>';
                }
            } else if (400 == result.status) {
                pageStr = '<td colspan="16" style="border: 1px solid #ccc"><p><h4 style="text-align: center;">暂无相关数据</h4></p></td>';
            }
            $("#showdisposepage").html(pageStr);

            $("#pageCount").html(result.data.totalCount);
            $("#pageIndex").html(result.data.pageIndex);
            $("#totalPageCount").html(result.data.totalPageCount);

            $("#hid_pageIndex").val(result.data.pageIndex);
            $("#hid_totalPageCount").val(result.data.totalPageCount);
        }
    });
}