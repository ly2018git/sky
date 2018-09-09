$(function () {
    //显示药品字典信息列表
    showDictionaries(1);

    /**
     * 首页
     */
    $("#homePage").click(function () {
        showDictionaries(1);
    });

    /**
     * 上一页
     */
    $("#prevPage").click(function () {
        var pageIndex = $("#hid_pageIndex").val();
        showDictionaries(pageIndex - 1 >= 1 ? pageIndex - 1 : 1);
    });

    /**
     * 下一页
     */
    $("#nextPage").click(function () {
        var pages = $("#hid_totalPageCount").val();
        var pageIndex = parseInt($("#hid_pageIndex").val());
        showDictionaries(pageIndex + 1 <= pages ? pageIndex + 1 : pages);
    });

    /**
     * 末页
     */
    $("#endPage").click(function () {
        var pages = $("#hid_totalPageCount").val();
        showDictionaries(pages);
    });

    /**
     * 按下回车执行模糊查询
     */
    $("#medicineName").keyup(function(){
        if(event.keyCode == 13){
            //显示查询字典信息
            showDictionaries(1);
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
        showDictionaries(num);
    }
}



/**
 * 显示药品字典信息列表
 * @param pageIndex
 */
function showDictionaries(pageIndex) {
    var pageSize=parseInt($("#showline").val());
    var medicineName = $("#medicineName").val();
    $.ajax({
        url: "showdictionaries",
        type: "POST",
        data: JSON.stringify({
            "medicineName": medicineName,
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
                        '<td>' + result.data.list[i].medicineName + '</td>' +
                        '<td>' + result.data.list[i].commonName + '</td>' +
                        '<td>' + result.data.list[i].tinySpecification + '</td>' +
                        '<td>' + result.data.list[i].manufacturerName + '</td>' +
                        '<td>' + result.data.list[i].dosageFormsName + '</td>' +
                        '<td>' + result.data.list[i].medicineKindName + '</td>' +
                        '<td>' + result.data.list[i].mCKName + '</td>' +
                        '<td>' + result.data.list[i].standardCode + '</td>';
                    pageStr += '</td></tr>';
                }
            } else if (400 == result.status) {
                pageStr = '<td colspan="16" style="border: 1px solid #ccc"><p><h4 style="text-align: center;">暂无相关数据</h4></p></td>';
            }
            $("#showdictionaries").html(pageStr);

            $("#pageCount").html(result.data.totalCount);
            $("#pageIndex").html(result.data.pageIndex);
            $("#totalPageCount").html(result.data.totalPageCount);

            $("#hid_pageIndex").val(result.data.pageIndex);
            $("#hid_totalPageCount").val(result.data.totalPageCount);
        }
    });
}