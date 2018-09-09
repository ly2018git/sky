$(function () {
    //显示库存盘点信息
    showStock(1);


    /**
     * 首页
     */
    $("#homePage").click(function () {
        showStock(1);
    });

    /**
     * 上一页
     */
    $("#prevPage").click(function () {
        var pageIndex = $("#hid_pageIndex").val();
        showStock(pageIndex - 1 >= 1 ? pageIndex - 1 : 1);
    });

    /**
     * 下一页
     */
    $("#nextPage").click(function () {
        var pages = $("#hid_totalPageCount").val();
        var pageIndex = parseInt($("#hid_pageIndex").val());
        showStock(pageIndex + 1 <= pages ? pageIndex + 1 : pages);
    });

    /**
     * 末页
     */
    $("#endPage").click(function () {
        var pages = $("#hid_totalPageCount").val();
        showStock(pages);
    });

    /**
     * 按下回车执行模糊查询
     */
    $("#medicineName").keyup(function () {
        if (event.keyCode == 13) {
            //显示库存盘点信息
            showStock(1);
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
        showStock(num);
    }
}




/**
 * 验证编辑库存信息
 */
function check(){
    //为提交按钮填充空属性
    $("#commit").attr("data-dismiss","");
    var number=$("#number").val();
    if(number==null||number=="") {
        alert("请输入库存量!");
    }else{
        editMedicine(number);
        //成功后为提交按钮填充关闭属性
        $("#commit").attr("data-dismiss","modal");
    }
}



/**
 * 编辑库存
 */
function editMedicine(number){
    var medicineId=$("#medId").val();
    $.ajax({
        url:"/stock/editmedicine",
        type:"get",
        data:{
            "number":number,
            "medicineId":medicineId
        },
        dataType:"json",
        contentType: "application/json; charset=utf-8",
        success:function(result){
            console.log(result);
            if(200==result.status){
                alert("编辑成功!");
                var index=$("#hid_pageIndex").val();
                showStock(parseInt(index));
            }else{
                alert("编辑失败,请稍后重试!");
            }
        }
    });
}


/**
 * 根据id获取药品信息
 * @param medicineId
 */
function showMedicineById(medicineId){
    $.ajax({
        url: "/stock/showmedicinebyid",
        type: "get",
        data: {"medicineId":medicineId},
        dataType: "json",
        contentType: "application/json; charset=utf-8",
                success: function (result) {
                console.log(result);
                if (200 == result.status) {
                    $("#medId").val(result.data.medicineId);
                    $("#medName").val(result.data.medicineName);
                    $("#commonName").val(result.data.commonName);
                    $("#specificationName").val(result.data.specificationName);
                    getAllDos(result.data.dosageFormsId);
                    $("#unitName").val(result.data.unitName);
                    $("#number").val(result.data.number);
                }
        }
    });
}

/**
 * 获取所有剂型填充到下拉框内
 * @param dosageFormsId
 */
function getAllDos(dosageFormsId) {
    $.ajax({
        url: "/stock/getalldos",
        type: "get",
        contentType: "application/json; charset=utf-8",
        success:function(result){
            console.log(result)
            var str='';
            if(200==result.status){
                for (var i = 0; i < result.data.length; i++) {
                    if(result.data[i].dosageFormsId==dosageFormsId){
                        str+='<option selected="selected" value="'+result.data[i].dosageFormsId+'">'+result.data[i].dosageFormsName+'</option>';
                    }else{
                        str+='<option value="'+result.data[i].dosageFormsId+'">'+result.data[i].dosageFormsName+'</option>';
                    }
                }
                $("#DosageFormsId").html(str);
            }
        }
    });
}

/**
 * 显示库存盘点信息列表
 * @param pageIndex
 */
function showStock(pageIndex) {
    var medicineName = $("#medicineName").val();
    var pageSize=parseInt($("#showline").val());
    $.ajax({
        url: "/stock/showstocklist",
        type: "POST",
        data: JSON.stringify({
            "medicineName": medicineName,
            "pageSize": pageSize,
            "pageIndex": pageIndex
        }),
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function (result) {
            console.log(result);
            if (200 == result.status) {
                var pageStr = '';
                for (var i = 0; i < result.data.list.length; i++) {
                    pageStr += '<tr role="row" class="odd">' +
                        '<td>' + result.data.list[i].medicineId + '</td>' +
                        '<td>' + result.data.list[i].medicineName + '</td>' +
                        '<td>' + result.data.list[i].commonName + '</td>' +
                        '<td>' + result.data.list[i].specificationName + '</td>' +
                        '<td>' + result.data.list[i].manufacturerName + '</td>' +
                        '<td>' + result.data.list[i].unitName + '</td>' +
                        '<td>' + result.data.list[i].comment + '</td>' +
                        '<td>' + result.data.list[i].validity + '</td>' +
                        '<td>' + result.data.list[i].batchNumber + '</td>' +
                        '<td>' + result.data.list[i].number + '</td>' +
                        '<td>' + result.data.list[i].salePrice + '</td>' +
                        '<td>' + result.data.list[i].purchasePrice + '</td>' +
                        '<td>' + result.data.list[i].profit + '</td>' +
                        '<td>' + result.data.list[i].ioDate + '</td>';
                    pageStr += '<td>' +
                        /*按钮触发模态框 */
                        '<button  data-toggle="modal" data-target="#myModal"  onclick="showMedicineById(' + parseInt(result.data.list[i].medicineId) + ')">编辑</button>' +
                        '</td></tr>';
                }
            } else if (400 == result.status) {
                pageStr = '<td colspan="16" style="border: 1px solid #ccc"><p><h4 style="text-align: center;">暂无相关数据</h4></p></td>';
            }
            $("#showstockpage").html(pageStr);

            $("#pageCount").html(result.data.totalCount);
            $("#pageIndex").html(result.data.pageIndex);
            $("#totalPageCount").html(result.data.totalPageCount);

            $("#hid_pageIndex").val(result.data.pageIndex);
            $("#hid_totalPageCount").val(result.data.totalPageCount);
        }
    });
}
