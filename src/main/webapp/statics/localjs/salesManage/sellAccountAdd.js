
$(function(){

//返回，跳转到销售营业额列表页面
    $("#back").click(function(){
        window.location.href="/sellAccount";
    });
//查询药品名
    loadMedicineName();
    //查询登录的用户名
    getUName();
    //查询所有vip
    loadVipId();
    //查询所有单位
    loadUnitName();


    medicineId=$("#medicineId");//药品id
    number=$("#number");//数量
    yaopinId=$("#yaopinId");
    PayWay=$("#PayWay");//支付方式
    vipId=$("#vipId");
    getvipid=$("#getvipid");//会员id
    UnitName=$("#UnitName");//药品单位名称

    /*验证销售员输入的药品数量是否正确*/
    number.on("blur",function(){
      var testGNum=$("#guiNum").val();
        if (number.val() <= testGNum && number.val() != ""&&number.val() != null) {
            //拿单价
            var danjia=$("#yincanPrice").val();
            var totalPrice=parseFloat(danjia*(number.val()));
            //销售总额
            $("#Amount").val(totalPrice);
            //应付金额
           $("#Due").val(totalPrice);
            //药品名称
            var yaoPinMing =$("#medicineName").val();
            //当不是会员的时候
            //实付金额
            $("#ActuallyPaid").val(totalPrice );
            //减免金额
            var annulPrice=0;
            $("#CutAmount").val(annulPrice);
            $("#CutComment").val("无减免");
            $("#comment").val("售出药品《"+yaoPinMing+"》"+number.val());



            validateTip($("#testGuiNum"), {"color": "green"}, imgYes + "",true);
        } else {
            validateTip($("#testGuiNum"), {"color": "red"}, imgNo + " 请确认数量是否正确！", false);

        }
    });

    /*验证单位名称*/
    UnitName.on("change",function() {
        if (UnitName.val() != null && UnitName.val() != "") {
            validateTip($("#danwei"), {"color": "green"}, imgYes + "",true);
        } else {
            validateTip($("#danwei"), {"color": "red"}, imgNo + " 请选择单位", false);

        }
    });
    /*验证--------------------begin*/
    medicineId.on("change",function() {
        if (medicineId.val()!=null&& medicineId.val() !="") {
            yaopinId.val(medicineId.val());
            /*begin----------*/
            var medicineId1=yaopinId.val();
            /*根据药品id查询柜台id*/
            getCounterByMedicineIdInfo(medicineId1);
            //根据柜台id查询柜台数量
           /* var guiId=$("#guitaiId").val();
            getCounterInfo(guiId);*/
            /*将药品销售价格查询出来显示在页面*/
            jQuery.ajax({
                url:'/getMedicineNameByMedicineId',//服务器端请求地址
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
                        //将根据药品id查询出来的药品销售价格放到页面的输入框中
                        var SalePrice=result.data.salePrice;
                        var ks= $("#SalePrice").val(SalePrice);
                        $("#yincanPrice").val(SalePrice);
                        //把查出来的药品名称放到页面上隐藏
                        var saleMedicineName=result.data.medicineName;
                        $("#medicineName").val(saleMedicineName);
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
/*验证支付方式*/
    PayWay.on("change",function() {
        if (PayWay.val() != null && PayWay.val() != "") {
            validateTip($("#zhifufangshi"), {"color": "green"}, imgYes + "",true);
        } else {
            validateTip($("#zhifufangshi"), {"color": "red"}, imgNo + " 请选择支付方式", false);

        }
    });
/*验证会员id*/
    vipId.on("change",function() {
        if (vipId.val() != null && vipId.val() != "") {
            getvipid.val(vipId.val());
            /*begin----------*/
            var vipid1=getvipid.val();
            /*将药品销售价格查询出来显示在页面*/
            jQuery.ajax({
                url:'/vip/getVipMsgModify',//服务器端请求地址
                type:'get',
                secureuri:false,//是否需要安全协议，一般设置为false
                contentType:'application/json;charset=utf-8',
                dataType:'json',//返回之类型一般设置为json
                data:{
                    "id":vipid1
                },
                success:function(result){
                    console.log(result);
                    if(200==result.status){
                        //将根据会员id查询出来的会员的积分和等级进行判断，然后进行会员的优惠计算付款金额
                       //拿单价
                        var danjia=$("#yincanPrice").val();
                        var totalPrice=parseFloat(danjia*(number.val()));
                        //销售总额
                        $("#Amount").val(totalPrice);
                        //应付金额
                        $("#Due").val(totalPrice);
                        //vip等级
                       var level= result.data.vipLevel;
                      //vip积分
                        var integral= result.data.integral;

                        //药品名称
                       var yaoPinMing =$("#medicineName").val();
                        if(level=="vip"&&integral>=20){
                            //重新没有选择
                            $("#xuanze").css('display',"none");
                            //普通会员每购买一次药品加5积分将剩余的积分传到页面
                            var shengyuIntegral=parseInt(integral-(integral/20)+5);
                            $("#syintegral").val(shengyuIntegral);
                            //实付金额
                            var actuallyPrice =parseFloat(totalPrice-integral/20);
                            $("#ActuallyPaid").val(actuallyPrice );
                            //减免金额
                            var annulPrice=parseFloat(totalPrice-actuallyPrice);
                           $("#CutAmount").val(annulPrice.toFixed(2));
                            $("#CutComment").val("会员积分抵扣"+annulPrice.toFixed(2)+"元");
                            $("#comment").val("售出药品《"+yaoPinMing+"》"+number.val());
                        }else if((level=="vips"&&integral>=20)||(level=="vips"&&integral<20)){
                            //如果是高级会员就显示可以选择优惠方式
                            $("#xuanze").css('display',"block");
                            //高级会员每购买一次药品加10积分将剩余的积分传到页面
                            var shengyuIntegraljifen=parseInt(integral+10);
                            $("#syintegral").val(shengyuIntegraljifen);
                            var val=$('input:radio[name="radiobutton"]:checked').val();
                            if(val==1){

                              /*  $("#sel1").on("click",function () {*/
                                    $("[name='radiobutton']:eq(0)").attr("checked",true);

                            //实付金额
                            var actuallyPrice =parseFloat(totalPrice/2);
                            $("#ActuallyPaid").val(actuallyPrice );
                            //减免金额
                            var annulPrice=parseFloat(totalPrice-actuallyPrice);
                            $("#CutAmount").val(annulPrice.toFixed(2));
                            $("#CutComment").val("高级VIP用户半价购买");
                            $("#comment").val("售出药品《"+yaoPinMing+"》"+number.val());
                             /*   });*/
                            }else if(val==2){

                              /*  $("#sel2").on("click",function () {*/
                                    $("[name='radiobutton']:eq(1)").attr("checked",true);

                                //实付金额
                                var actuallyPrice =parseFloat(totalPrice-integral/20);
                                if(actuallyPrice>0&&actuallyPrice<totalPrice){

                                $("#ActuallyPaid").val(actuallyPrice );
                                //减免金额
                                var annulPrice=parseFloat(totalPrice-actuallyPrice);
                                $("#CutAmount").val(annulPrice.toFixed(2));
                                $("#CutComment").val("会员积分抵扣"+annulPrice.toFixed(2)+"元");
                                $("#comment").val("售出药品《"+yaoPinMing+"》"+number.val());
                                }else if(actuallyPrice==totalPrice){
                                    $("#ActuallyPaid").val(actuallyPrice );
                                    //减免金额
                                    var annulPrice=parseFloat(totalPrice-actuallyPrice);
                                    $("#CutAmount").val(annulPrice.toFixed(2));
                                    $("#CutComment").val("无减免");
                                    $("#comment").val("售出药品《"+yaoPinMing+"》"+number.val());
                                }


                             /*   });*/
                            }else{
                                alert("请选择优惠方式");
                            }

                        }else if((level=="vip"&&integral<20)){
                            //重新没有选择
                            $("#xuanze").css('display',"none");
                            //普通会员每购买一次药品加5积分将剩余的积分传到页面
                            var shengyuIntegral=parseInt(integral-(integral/20)+5);
                            $("#syintegral").val(shengyuIntegral);
                            //实付金额
                            var actuallyPrice =parseFloat(totalPrice);
                            $("#ActuallyPaid").val(actuallyPrice );
                            //减免金额
                            var annulPrice=parseFloat(totalPrice);
                            $("#CutAmount").val(annulPrice);
                            $("#CutComment").val("无减免");
                            $("#comment").val("售出药品《"+yaoPinMing+"》"+number.val());
                        }

                    }
                },
                error:function(data,status,e){
                    alert("请求失败，请稍后重试");
                }
            });
            /*end-------------*/
           /* validateTip($("#huiyuanid"), {"color": "green"}, imgYes + "",true);*/
        } else {
            /*validateTip($("#huiyuanid"), {"color": "red"}, imgNo + " 请选择会员编号", false);*/

        }
    });
//保存,添加销售药品信息
    $("#btn_add").click(function(){
        //销售人id
        var UID=$("#yUID").val();
        var medicineId1=$("#medicineId").val();
        var medicineId2=$("#medicineId").val();
        var number1=jQuery("#number").val().trim();
        var number2=jQuery("#number").val().trim();
        var SalePrice=$("#SalePrice").val();
        var vipId1=$("#vipId option:selected").val();
        //销售总额
        var Amount=$("#Amount").val();
        //根据会员id查询会员的积分和会员的等级，如果是会员等级是超级会员（不管积分）直接半价
        //如果会员等级是普通会员，则查看积分，积分不足则无优惠（20积分减一块钱），积分足够则
        // 按每20积分减1块钱，依次累加
        //实付金额
        var ActuallyPaid=$("#ActuallyPaid").val();
        //应付金额
        var Due=$("#Due").val();
        //减免金额
        var CutAmount=$("#CutAmount").val();
        //减免说明
        var CutComment=$("#CutComment").val();
        var PayWay1=$("#PayWay option:selected").val();
        //账单备注
        var comment=$("#comment").val();
        //单位名
        var UnitName1=$("#UnitName option:selected").val();
        //合拼的账单备注
        var commentUnitName=comment+UnitName1;
        //销售员
        var yUName=$("#yUName").val();
        //柜台id
        var counterId = $("#guitaiId").val();

        UnitName.change();
        medicineId.change();
        vipId.change();
        number.blur();
        if(UnitName.attr("validateStatus") == "true"&&
            medicineId.attr("validateStatus") == "true"&&
            /*vipId.attr("validateStatus") == "true"&&*/
            number.attr("validateStatus") == "true"
        ) {


            /*end------*/
            jQuery.ajax({
                url: '/addSellAccount',//服务器端请求地址
                type: 'post',
                secureuri: false,//是否需要安全协议，一般设置为false
                contentType: 'application/json;charset=utf-8',
                dataType: 'json',//返回之类型一般设置为json
                data: JSON.stringify({
                    "UID": UID,
                    "vipId": vipId1,
                    "amount": Amount,
                    "actuallyPaid": ActuallyPaid,
                    "due": Due,
                    "cutAmount": CutAmount,
                    "cutComment": CutComment,
                    "payWay": PayWay1,
                    "comment": commentUnitName,
                    "salesman": yUName,
                    "counterId":counterId
                }),
                success: function (result) {
                    console.log(result);
                    if (200 == result.status) {
                        /*添加销售详情--begin*/
                        AddSellItem(medicineId1,number1);
                        //window.location.href = "/sellAccount";
                    } else {

                    }
                }
            });
/*销售账单提交成功之后进行如下操作*/

            /*修改柜台数量，取出柜台id*/
            var gId=$("#guitaiId").val();
            modifyCounterNum(gId,number2);
            /*会员剩余积分*/
            var shengYuIntegral= $("#syintegral").val();
            if(vipId1!=null&&shengYuIntegral!=null){
            modifyCounterVipIntegral(vipId1,shengYuIntegral);
            }
        }
    });

});
/*添加销售详情记录-----------------------------begin*/
function AddSellItem(medicineId1,number1){
    jQuery.ajax({
        url: '/addSellItem',//服务器端请求地址
        type: 'post',
        secureuri: false,//是否需要安全协议，一般设置为false
        contentType: 'application/json;charset=utf-8',
        dataType: 'json',//返回之类型一般设置为json
        data: JSON.stringify({
            "medicineId": medicineId1,
            "number": number1,
        }),
        success: function (result) {
            console.log(result);
            if (200 == result.status) {
               // window.location.href = "/getSellAccountInfoPage";
                alert("保存成功");
                $('#formId')[0].reset();
                $("#xuanze").css('display',"none");
            } else {
                alert("保存失败！");
            }
        }
    });
}

/*添加完成之后，修改柜台的数量*/
function modifyCounterNum(gId,number2){
    //柜台上的药品数量
    var zonCounterNum=$("#guiNum").val();
    //柜台剩余数量
    var shengyuCounterNum=parseInt(zonCounterNum-number2);
    jQuery.ajax({
        url:'/counterModifyNum',//服务器端请求地址
        type:'post',
        secureuri:false,//是否需要安全协议，一般设置为false
        contentType:'application/json;charset=utf-8',
        dataType:'json',//返回之类型一般设置为json
        data:JSON.stringify({
            "counterId":gId,
            "number":shengyuCounterNum
        }),
        success:function(result){
            console.log(result);
            if(200==result.status){
               //修改柜台数量

            }
        },
        error:function(data,status,e){
            alert("请求失败，请稍后重试");
        }
    });
}
/*添加完成之后修改会员积分*/
function modifyCounterVipIntegral(vipId1,shengYuIntegral){
    jQuery.ajax({
        url:'/vip/counterModifyVipIntegral',//服务器端请求地址
        type:'post',
        secureuri:false,//是否需要安全协议，一般设置为false
        contentType:'application/json;charset=utf-8',
        dataType:'json',//返回之类型一般设置为json
        data:JSON.stringify({
            "id":vipId1,
            "integral":shengYuIntegral
        }),
        success:function(result){
            console.log(result);
            if(200==result.status){
                //修改柜台数量

            }
        },
        error:function(data,status,e){
            alert("请求失败，请稍后重试");
        }
    });
}

/*end-----------------------------------------------*/
/**
 * 根据登录的用户id查询用户的姓名
 */

function getUName(){
    var UID=1;
    jQuery.ajax({
        type:"get",
        url:"/getUNameByUID",
        dataType:"json",
        contentType:"application/json;charset=utf-8",
        data:{"UID":UID},
        success:function(result){
            console.log(result);
            if(200==result.status){
                $("#yUID").val(UID);
                var userName=result.data.uname;
                $("#yUName").val(userName);
            }
        }
    });
}
/**
 * 查询所有药品(根据柜台表有的药品名称)
 */

function loadMedicineName(){
    $("#medicineId").html("");
    jQuery.ajax({
        type:"get",
        url:"/getAllMedicineNameByCounter",
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
 * 查询所有会员
 */

function loadVipId(){
    $("#vipId").html("");
    jQuery.ajax({
        type:"post",
        url:"/vip/getAllVip",
        dataType:"json",
        contentType:"application/json;charset=utf-8",
        data:{},
        success:function(result){
            console.log(result);
            var optionStr="<option value='' selected='selected'>--请选择--</option>";
            if(200==result.status){
                if(result.data!=null){
                    for(var t=0;t<result.data.length;t++){
                        optionStr+="<option value='"+result.data[t].id+"'>"+result.data[t].id+"</option>";
                    }
                }
                $("#vipId").html(optionStr);
            }
        }
    });
}
/*查询所有单位*/
function loadUnitName(){
    $("#UnitName").html("");
    jQuery.ajax({
        type:"get",
        url:"/getAllUnitName",
        dataType:"json",
        contentType:"application/json;charset=utf-8",
        data:{},
        success:function(result){
            console.log(result);
            var optionStr="<option value='' selected='selected'>--请选择--</option>";
            if(200==result.status){
                if(result.data!=null){
                    for(var t=0;t<result.data.length;t++){
                        optionStr+="<option value='"+result.data[t].unitName+"'>"+result.data[t].unitName+"</option>";
                    }
                }
                $("#UnitName").html(optionStr);
            }
        }
    });
}

/*根据柜台id查询柜台数量*/
/*function getCounterInfo(guiId){
    $.getJSON("/getCounterMsgModify",{"counterId":guiId},
        function success(result){
            console.log(result);
            if(200==result.status){
               //将查询出来的数量放到页面中
                $("#guiNum").val(result.data.number);
            }
        });
}*/

/*根据选择的药品id查询柜台id*/
function getCounterByMedicineIdInfo(medicineId1){

    $.getJSON("/getExsistByMedicineId",{"MedicineId":medicineId1},
        function success(result){
            console.log(result);
            if(200==result.status){
                //将查询出来的柜台id和数量放到页面中
                $("#guitaiId").val(result.data.counterId);
                $("#guiNum").val(result.data.number);
            }
        });
}