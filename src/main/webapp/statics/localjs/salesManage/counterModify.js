$(function(){
    getCounterInfo();

    loadMedicineName();
    loadGoodsallocationName();

    medicineId=$("#medicineId");
    number=$("#number");
    GAID=$("#GAID");
    yaopinId=$("#yaopinId");



    /*验证--------------------begin*/
    medicineId.on("blur",function() {
        if (medicineId.val()!=null&& medicineId.val() !="") {
            yaopinId.val(medicineId.val());
            /*begin----------*/
            var medicineId1=yaopinId.val();
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
                        $("#number").val(0);
                    }
                },
                error:function(data,status,e){
                    alert("请求失败，请稍后重试");
                }
            });
            /*end-------------*/
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
            validateTip($("#shuliang"), {"color": "red"}, imgNo + " 请输入正确的数字！", false);
        }
    });

    GAID.on("change",function() {
        if (GAID.val() != null && GAID.val() != "") {
            validateTip($("#huowei"), {"color": "green"}, imgYes + "",true);
        } else {
            validateTip($("#huowei"), {"color": "red"}, imgNo + " 请选择药品摆放货位", false);

        }
    });
/*end--------------*/
//返回
    $("#back").click(function(){
       /* window.location.href="/counter";*/
        window.history.back(-1);
    });




//保存，修改app基础信息
    $("#btn_modify").click(function(){
        var counterId=getPath("counterId");
        var medicineId1=$("#medicineId option:selected").val();
        var GAID1=$("#GAID option:selected").val();
        //用户输入的数量
        var number1=$("#number").val();
        //查询出来的数量
        var chaxunNum=$("#chaxunNum").val();
        //总数量
        var totalNum=parseInt(number1+chaxunNum);
        if(totalNum>5){
            alert("超出柜台上限了！");
            return false;
        }
        /*medicineId.change();*/
        medicineId.blur();
        number.blur();
        GAID.change();
        if(medicineId.attr("validateStatus") == "true"
            && number.attr("validateStatus") == "true"
            &&GAID.attr("validateStatus") == "true"
        ) {
            jQuery.ajax({
                url:'/counterModifySave',//服务器端请求地址
                type:'post',
                secureuri:false,//是否需要安全协议，一般设置为false
                fileElementId:'attach',//文件上传域的id
                contentType:'application/json;charset=utf-8',
                dataType:'json',//返回之类型一般设置为json
                data:JSON.stringify({
                    "counterId":counterId,
                    "MedicineId":medicineId1,
                    "number":totalNum,
                    "GAID":GAID1
                }),
                success:function(result){
                    console.log(result);
                    if(200==result.status){
                        alert("保存成功");
                        window.location.href="/counter";
                    }else{
                        alert("保存失败");
                    }
                },
                error:function(data,status,e){
                    alert("请求失败，请稍后重试");
                }
            });
        }
    });
    /*END*/
});

//根据id查出所有的信息
function getCounterInfo(){
    var counterId=getPath("counterId");
    $.getJSON("/getCounterMsgModify",{"counterId":counterId},
        function success(result){
            console.log(result);
            if(200==result.status){
                $("#counterId").val(result.data.counterId);
                $("#medicineId").val(result.data.medicineId);
                $("#number").val(result.data.number);
                //隐藏域查出来本身具有的数量
                $("#chaxunNum").val(result.data.number);
                $("#GAID").val(result.data.gAID);
            }
        });
}
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
            var optionStr="<option value=''>--请选择--</option>";
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
            var optionStr="<option value=''>--请选择--</option>";
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