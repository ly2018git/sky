$(function(){
    getVipInfo();


//返回
$("#back").click(function(){
    window.location.href="/vip/vipManage";
});




//保存，修改vip基础信息
$("#btn_modify").click(function(){
    var id=getPath("id");
    var vipName=$("#vipName").val();
    var vipLevel=$("#vipLevel option:selected").val();
    var sex=$("#sex option:selected").val();
    var phone=$("#phone").val();
    var address=$("#address").val();
    if(vipName==""||vipLevel==""||sex==""||phone==""||address==""){
        alert("信息不完整，请补充完整！");
    }else{
        jQuery.ajax({
            url:'/vip/vipModifySave',//服务器端请求地址
            type:'post',
            secureuri:false,//是否需要安全协议，一般设置为false
            contentType:'application/json;charset=utf-8',
            dataType:'json',//返回之类型一般设置为json
            data:JSON.stringify({
                "id":id,
                "vipName":vipName,
               "vipLevel":vipLevel,
                "sex":sex,
                "phone":phone,
                "address":address
            }),
            success:function(result){
                console.log(result);
                if(200==result.status){
                    alert("保存成功");
                    window.location.href="/vip/vipManage";
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
function getVipInfo(){
    var id=getPath("id");
    $.getJSON("/vip/getVipMsgModify",{"id":id},
        function success(result){
            console.log(result);
            if(200==result.status){
                $("#id").val(result.data.id);
                $("#vipName").val(result.data.vipName);
                $("#vipLevel").val(result.data.vipLevel);
                $("#sex").val(result.data.sex);
                $("#phone").val(result.data.phone);
                $("#address").val(result.data.address);
            }
        });
}