$(function(){
    loadMedicineName();
    loadGoodsallocationName();
    $("#back").click(function(){
       /* window.location.href="/counter";*/
        window.history.back(-1);
    })
medicineId=$("#medicineId");
number=$("#number");
GAID=$("#GAID");
yaopinId=$("#yaopinId");



/*验证*/
medicineId.on("change",function() {

    if (medicineId.val()!=null&& medicineId.val() !="") {
        yaopinId.val(medicineId.val());
        /*begin----------*/
        var medicineId1=yaopinId.val();
        var medicineId2=yaopinId.val();
        /*验证改药品在是否已经添加(查柜台中的药品id是否已经存在（是否有数据）*/
        /*begin----------------------------*/
        //repetitionMedicine(medicineId1);




        /*end-------------------*/
        /*将库存数量查询出来显示在页面*/
        jQuery.ajax({
            url:'/getWarehouseById',//服务器端请求地址
            type:'get',
            secureuri:false,//是否需要安全协议，一般设置为false
            contentType:'application/json;charset=utf-8',
            dataType:'json',//返回之类型一般设置为json
            data:{
                "medicineId":medicineId1
            },
            success:function(result){
                console.log(result);
                if(200==result.status){
                    //将根据药品id查询出来的库存放到页面的输入框中
                    var kucunNum=result.data.number;
                    if(kucunNum!=null){
                   var ks= $("#kucuns").val(kucunNum);
                    }
                }else{
                    var ks=$("#kucuns").val("没有库存");
                }
            },
            error:function(data,status,e){
                alert("请求失败，请稍后重试");
            }
        });
        /*end-------------*/
        jQuery.ajax({
            url:'/getExsistByMedicineId',//服务器端请求地址
            type:'get',
            secureuri:false,//是否需要安全协议，一般设置为false
            contentType:'application/json;charset=utf-8',
            dataType:'json',//返回之类型一般设置为json
            data:{
                "MedicineId":medicineId2
            },
            success:function(res){
                console.log(res);
                if(200==res.status){
                    //根据药品id查询柜台表中是否有数据，有数据就必须要重新
                    // 选择药品添加到柜台
                    alert("该药品柜台已存在，请重新选择药品");
                    yaopinId.val("");
                    return false;
                }
            },
            error:function(data,status,e){
                alert("请求失败，请稍后重试");
            }
        });

        validateTip($("#mingcheng"), {"color": "green"}, imgYes + "",true);
    } else {
        validateTip($("#mingcheng"), {"color": "red"}, imgNo + " 请选择药品！", false);

    }
});



    /*判断添加到柜台的药品数量，库存中是否足够*/
number.on("blur",function() {
    var testNum=/^[0-5]{1}$/;
    var medicineId1=yaopinId.val();
    var number1=$("#number").val();
    //显示的库存数量有值或者没有库存
    var kucun=$("#kucuns").val();
    if(kucun=="没有库存"){
        alert("库存不足!请重新选择药品！");
        return false;
    }
    if (number.val().match(testNum)) {
    jQuery.ajax({
        url:'/getWarehouseById',//服务器端请求地址
        type:'get',
        secureuri:false,//是否需要安全协议，一般设置为false
        contentType:'application/json;charset=utf-8',
        dataType:'json',//返回之类型一般设置为json
        data:{
            "medicineId":medicineId1
        },
        success:function(result){
            console.log(result);
            if(200==result.status){
                //将根据药品id查询出来的库存和输入的数量进行比较
                var kucunNum=result.data.number;
                $("#kucun").val(kucunNum);
                var shengyu= kucunNum - number1;
                if(shengyu<0){
                    alert("库存不足");
                }
            }
        },
        error:function(data,status,e){
            alert("请求失败，请稍后重试");
        }
    });
        validateTip($("#shuliang"), {"color": "green"}, imgYes + "", true);
    } else {
        validateTip($("#shuliang"), {"color": "red"}, imgNo + " 请输入正确的数字,柜台最多放5件药品！", false);
    }
});

GAID.on("change",function() {
    if (GAID.val() != null && GAID.val() != "") {
        validateTip($("#huowei"), {"color": "green"}, imgYes + "",true);
    } else {
        validateTip($("#huowei"), {"color": "red"}, imgNo + " 请选择药品摆放货位", false);

    }
});


/*添加柜台销售*/
$("#addcounter").click(function(){
   /* var medicineId1=$("#medicineId option:selected").val();*/
    var medicineId1=yaopinId.val();
    var number1=$("#number").val();
    var GAID1=$("#GAID option:selected").val();
    medicineId.change();
    number.blur();
    GAID.change();
    if(medicineId.attr("validateStatus") == "true"
        && number.attr("validateStatus") == "true"
        &&GAID.attr("validateStatus") == "true"
    ) {
        jQuery.ajax({
            url:'/addCounter',//服务器端请求地址
            type:'post',
            secureuri:false,//是否需要安全协议，一般设置为false
            contentType:'application/json;charset=utf-8',
            dataType:'json',//返回之类型一般设置为json
            data:JSON.stringify({
                "MedicineId":medicineId1,
                "number":number1,
                "GAID":GAID1
            }),
            success:function(result){
                console.log(result);
                if(200==result.status){
                    alert("保存成功");
                    window.location.href="/counter";
                }else{
                    alert("保存失败！");
                }
            },
            error:function(data,status,e){
                alert("请求失败，请稍后重试");
            }
        });
    }

});

});


/**
 * 查询所有药品
*/

function loadMedicineName(){
    $("#medicineId").html("");
    jQuery.ajax({
        type:"get",
        url:"/getMedicineName",
        dataType:"json",
        contentType:"application/json;charset=utf-8",
        data:{},
        success:function(result){
            console.log(result);
            var optionStr="<option value='' selected='selected'>--请选择--</option>";
            if(200==result.status){
                if(result.data!=null){
                    for(var t=0;t<result.data.length;t++){
                        optionStr+="<option value='"+result.data[t].medicineId+"'>"+result.data[t].medicineName+"</option>";
                    }
                }
                $("#medicineId").html(optionStr);
            }
        }
    });
}
/**
 *查询所有货位
 */
function loadGoodsallocationName(){
    $("#GAID").html("");
    jQuery.ajax({
        type:"get",
        url:"/getGoodsallocation",
        dataType:"json",
        contentType:"application/json;charset=utf-8",
        data:{},
        success:function(result){
            console.log(result);
            var optionStr="<option value='' selected='selected'>--请选择--</option>";
            if(200==result.status){
                if(result.data!=null){

                    for(var t=0;t<result.data.length;t++){
                        optionStr+="<option value='"+result.data[t].gaid
                            +"'>"+result.data[t].ganame
                            +"</option>";
                    }

                }
                $("#GAID").html(optionStr);
            }
        }
    });
}


