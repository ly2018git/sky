$(function () {
    showAdjust(1);

    /**
     * 首页
     */
    $("#homePage").click(function () {
        showAdjust(1);
    });

    /**
     * 上一页
     */
    $("#prevPage").click(function () {
        var pageIndex = $("#hid_pageIndex").val();
        showAdjust(pageIndex - 1 >= 1 ? pageIndex - 1 : 1);
    });

    /**
     * 下一页
     */
    $("#nextPage").click(function () {
        var pages = $("#hid_totalPageCount").val();
        var pageIndex = parseInt($("#hid_pageIndex").val());
        showAdjust(pageIndex + 1 <= pages ? pageIndex + 1 : pages);
    });

    /**
     * 末页
     */
    $("#endPage").click(function () {
        var pages = $("#hid_totalPageCount").val();
        showAdjust(pages);
    });


    /**
     * 全选与反选
     */
    $("#checkAll").click(function() {
        var flag=this.checked;
        $("input[name='check']").each(function(){
            $(this).attr('checked',flag);
        });
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
        showAdjust(num);
    }
}



/**
 * 调价
 */
function changePrice() {
    //获取折扣的值
    var discount = parseFloat($("#discount").val());
    //判断是否选择折扣
    if(discount == "0"){
        alert("请选择折扣!");
    }else{
        //获取多选框的值
        var obj = document.getElementsByName("check");
        var check_val = [];
        for (var k in obj) {
            //遍历多选框被选中的值
            if (obj[k].checked) {
                //添加到数组中
                check_val.push(obj[k].value);
            }
        }
        if (check_val.length > 0) {
            $.ajax({
                url: "changeprice",
                type: "get",
                data: {
                    "item": check_val,
                    "discount": discount
                },
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                success: function (result) {
                    console.log(result);
                    if (200 == result.status) {
                        alert("调价成功!");
                    } else {
                        alert("调价失败!");
                    }
                    var index = $("#hid_pageIndex").val();
                    //移除全选框的属性值
                    $("#checkAll").removeAttr("checked");
                    showAdjust(parseInt(index));
                }
            });
        }else{
            alert("请选择药品!");
        }
    }
}


/**
 * 显示调价促销信息列表
 * @param pageIndex
 */
function showAdjust(pageIndex) {
    var pageSize = parseInt($("#showline").val());
    var medicineName = $("#medicineName").val();
    var number = $("#number").val();
    var number2 = parseInt(number) + parseInt(100);
    var chooseDate = $("#chooseDate").val();
    $("#discount").val("0");
    $.ajax({
        url: "/stock/showadjustlist",
        type: "POST",
        data: JSON.stringify({
            "medicineName": medicineName,
            "number": number,
            "number2": number2,
            "chooseDate": chooseDate,
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
                        '<td><input value="' + parseInt(result.data.list[i].medicineId) + '" id="check" name="check" type="checkbox" class="checkall" style="width: 20px;"/></td>' +
                        '<td>' + result.data.list[i].medicineId + '</td>' +
                        '<td>' + result.data.list[i].medicineName + '</td>' +
                        '<td>' + result.data.list[i].manufacturerName + '</td>' +
                        '<td>' + result.data.list[i].specificationName + '</td>' +
                        '<td>' + result.data.list[i].unitName + '</td>' +
                        '<td>' + result.data.list[i].number + '</td>' +
                        '<td>' + result.data.list[i].batchNumber + '</td>' +
                        '<td>' + result.data.list[i].purchasePrice + '</td>' +
                        '<td>' + result.data.list[i].salePrice + '</td>' +
                        '<td>' + result.data.list[i].purchasePrice + '</td>' +
                        '<td>20</td>' +
                        '<td>' + result.data.list[i].comment + '</td>' +
                        '<td>' + result.data.list[i].ioDate + '</td>' +
                        '<td>' + result.data.list[i].validity + '</td>' +
                        '<td>' + result.data.list[i].dosageFormsName + '</td></tr>';
                }
            } else if (400 == result.status) {
                pageStr = '<td colspan="16" style="border: 1px solid #ccc"><p><h4 style="text-align: center;">暂无相关数据</h4></p></td>';
            }
            $("#showadjustpage").html(pageStr);

            $("#pageCount").html(result.data.totalCount);
            $("#pageIndex").html(result.data.pageIndex);
            $("#totalPageCount").html(result.data.totalPageCount);

            $("#hid_pageIndex").val(result.data.pageIndex);
            $("#hid_totalPageCount").val(result.data.totalPageCount);
        }
    });
}