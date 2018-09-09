package com.skyhospital.controller;

import com.alibaba.fastjson.JSON;
import com.skyhospital.pojo.*;
import com.skyhospital.service.drug.GoodsallocationService;
import com.skyhospital.service.drug.MedicineService;
import com.skyhospital.service.drug.UnitService;
import com.skyhospital.service.sales.CounterService;
import com.skyhospital.service.sales.SellaccountService;
import com.skyhospital.service.sales.SellitemService;
import com.skyhospital.service.stock.WarehouseService;
import com.skyhospital.service.user.ShiftService;
import com.skyhospital.service.user.UserService;
import com.skyhospital.tools.AppReturn;
import com.skyhospital.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：SalesController
 * 描述：销售管理
 * 创建时间：2018.08.21 下午 01:37
 * 创建者: Rita
 */
@Controller
public class SalesController {
    //------------------------------------------------  柜台销售计划
    @Autowired
    private CounterService counterService;
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private GoodsallocationService goodsallocationService;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private UserService userService;
    @Autowired
    private UnitService unitService;
    @Autowired
    private SellitemService sellitemService;



    //跳转到柜台销售计划列表页面
    @RequestMapping(value="/counter")
    public String SellCounterList(){
        return "Counter";
    }

    @RequestMapping(value="/getCounterInfoPage",method= RequestMethod.POST)
    @ResponseBody
    public Object getCounterInfoPage(@RequestBody Map<String, Object> map){
        AppReturn appReturn=new AppReturn();
        PageUtil<Counter> pageUtil=new PageUtil<>();
        try {
            pageUtil=counterService.findCounterPage(map);
            if(pageUtil.getList().size()>0){
                appReturn= AppReturn.ok(pageUtil);//status=200
            }else{
                appReturn=AppReturn.build(400, "暂无数据", pageUtil);//status=400
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "系统发生异常", null);
        }
        return JSON.toJSON(appReturn);
    }


    //---------------------------------------------- 销售营业额
    @Autowired
    private SellaccountService sellaccountService;
    //跳转到销售营业额列表页面
    @RequestMapping(value="/sellAccount")
    public String SellAccount(){
        return "sellAccountList";
    }

    //跳转到添加销售药品页面
    @RequestMapping(value="/sellAccountAdd")
    public String SellAccountAdd(){
        return "SellAccountAdd";
    }

    /*添加销售药品账单-------------*/
    @RequestMapping(value="/addSellAccount",method=RequestMethod.POST)
    @ResponseBody
    public Object SellAccountAdd(@RequestBody Sellaccount sellaccount){
        AppReturn appReturn=new AppReturn();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String dindang= sdf.format(new Date());
            //销售账单号
            sellaccount.setSellAccountId("SD"+dindang);
            //销售时间
            sellaccount.setSellDate(new Date());
            //结算时间
            sellaccount.setClosingDate(new Date());
            //销售人
            sellaccount.setUID(1);
            //新增销售药品信息到数据库中
            if(sellaccountService.addSellCount(sellaccount)>0){
                //成功
                appReturn=AppReturn.succeed();
            }else{
                //失败
                appReturn=AppReturn.defeated();
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "异常", null);
        }
        return JSON.toJSON(appReturn);
    }
    //添加药品销售详情
    @RequestMapping(value="/addSellItem",method=RequestMethod.POST)
    @ResponseBody
    public Object SellItemAdd(@RequestBody Sellitem sellitem){
        AppReturn appReturn=new AppReturn();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String dindang= sdf.format(new Date());
            //销售账单号
            sellitem.setSellAccountId("SD"+dindang);
            int i = sellitemService.addSellItem(sellitem);
            //新增销售药品信息到数据库中
            if(i>0){
                //成功
                appReturn=AppReturn.succeed();
            }else{
                //失败
                appReturn=AppReturn.defeated();
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "异常", null);
        }
        return JSON.toJSON(appReturn);
    }
    /*------------------end*/
    //分页
    @RequestMapping(value="/getSellAccountInfoPage",method= RequestMethod.POST)
    @ResponseBody
    public Object getSellAccountInfoPage(@RequestBody Map<String, Object> map){
        AppReturn appReturn=new AppReturn();
        PageUtil<Sellaccount> pageUtil=new PageUtil<>();
        try {
            pageUtil=sellaccountService.findSaleTurnover(map);
            if(pageUtil.getList().size()>0){
                appReturn= AppReturn.ok(pageUtil);//status=200
            }else{
                appReturn=AppReturn.build(400, "暂无数据", pageUtil);//status=400
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "系统发生异常", null);
        }
        return JSON.toJSON(appReturn);
    }


    //-----------------------------------药品销售列表

    //跳转到药品销售列表页面
    @RequestMapping(value="/sellItem")
    public String SellItemList(){
        return "sellItemList";
    }

    @RequestMapping(value="/getSellItemInfoPage",method= RequestMethod.POST)
    @ResponseBody
    public Object getSellItemInfoPage(@RequestBody Map<String, Object> map){
        AppReturn appReturn=new AppReturn();
        PageUtil<Sellitem> pageUtil=new PageUtil<>();
        try {
            pageUtil=sellitemService.findSellItem(map);
            if(pageUtil.getList().size()>0){
                appReturn= AppReturn.ok(pageUtil);//status=200
            }else{
                appReturn=AppReturn.build(400, "暂无数据", pageUtil);//status=400
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "系统发生异常", null);
        }
        return JSON.toJSON(appReturn);
    }


    //-------------------------------------销售员交班
    @Autowired
    private ShiftService shiftService;
    //跳转到销售员交班添加界面
    @RequestMapping(value="/shift")
    public String shiftadd(){
        return "SaleShiftAdd";
    }

    //销售员交班
    @RequestMapping(value="/addShift",method=RequestMethod.POST)
    @ResponseBody
    public Object appinfoaddAdd(@RequestBody Shift shiftInfo, HttpSession session, HttpServletRequest request){
        AppReturn appReturn=new AppReturn();
        try {
            //交班时间
            shiftInfo.setShiftTime(new Date());

            //交班人
            shiftInfo.setUID(1);
            //新增会员信息到数据库中
            if(shiftService.addShift(shiftInfo)>0){
                //成功
                appReturn=AppReturn.succeed();
            }else{
                //失败
                appReturn=AppReturn.defeated();
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "异常", null);
        }
        return JSON.toJSON(appReturn);

    }
    /*跳转到修改柜台销售页面*/
    @RequestMapping(value="/counterModify")
    public String appInfoModify(){
        return "CounterModify";
    }

    //查出要修改的所有的柜台信息
    @RequestMapping(value="/getCounterMsgModify",method = RequestMethod.GET)
    @ResponseBody
    public Object modifyViewCounterById(@RequestParam String counterId){
        AppReturn appReturn=new AppReturn();
        //根据id查询user表中的数据
        Counter counter=counterService.getCounterMsgById(Integer.parseInt(counterId));
        //传数据给前端
        try {
            if(null!=counter){
                appReturn=AppReturn.ok(counter);
            }else{
                appReturn=AppReturn.build(400, "暂无数据", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "系统发生异常", null);
        }
        return JSON.toJSON(appReturn);
    }

    //修改柜台基础信息
    @RequestMapping(value="/counterModifySave",method=RequestMethod.POST)
    @ResponseBody
    public Object modifySave(@RequestBody Counter counter){
        AppReturn appReturn=new AppReturn();
        try {

            //修改柜台信息到数据库中
            if(counterService.modifyCounter(counter)>0){
                //成功
                appReturn=AppReturn.succeed();
            }else{
                //失败
                appReturn=AppReturn.defeated();
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "异常", null);
        }
        return JSON.toJSON(appReturn);
    }

    /*end---------------------*/
    /*跳转到添加柜台销售页面*/
    @RequestMapping(value="/counterAdd")
    public String counterAdd(){
        return "CounterAdd";
    }
    //添加柜台销售
    @RequestMapping(value="/addCounter",method=RequestMethod.POST)
    @ResponseBody
    public Object CounterAdd(@RequestBody Map<String,String> map){
        AppReturn appReturn=new AppReturn();
        try {
            Counter counter=new Counter();
            counter.setGAID(Integer.valueOf(map.get("GAID").toString()));
            counter.setMedicineId(Integer.valueOf(map.get("MedicineId").toString()));
            counter.setNumber(Integer.valueOf(map.get("number").toString()));
            //柜台上限
            counter.setUpper(5);
            //柜台下限
            counter.setLower(1);
            //新增会员信息到数据库中
            if(counterService.addCounter(counter)){
                //成功
                appReturn=AppReturn.succeed();
            }else{
                //失败
                appReturn=AppReturn.defeated();
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "异常", null);
        }
        return JSON.toJSON(appReturn);

    }

    /*---------------------------------查询所有药品名称*/
    /**
     * 查询所有药品名称
     */
    @RequestMapping("/getMedicineName")
    @ResponseBody
    public AppReturn getAppCategoryListByParentId(){
        AppReturn appReturn=new AppReturn();
        try {
            List<Medicine> list=medicineService.findAllMedicine();
            if(list.size()>0){
                appReturn=AppReturn.ok(list);//status=200
            }else{
                appReturn=AppReturn.defeated();//status=400
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "系统发生异常", null);
        }
        return appReturn;
    }

    /*--------------------------------------查询所有货位名称*/
    /**
     * 查询所有货位名称
     */
    @RequestMapping("/getGoodsallocation")
    @ResponseBody
    public Object getGoodsallocation(){
        AppReturn appReturn=new AppReturn();
        try {
            List<Goodsallocation> list=goodsallocationService.findAllGAName();
            if(list.size()>0){
                appReturn=AppReturn.ok(list);//status=200
            }else{
                appReturn=AppReturn.defeated();//status=400
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "系统发生异常", null);
        }
        return appReturn;
    }

    /*--------------------------------------查询库存数量*/
    /*查询库存数量*/
    @RequestMapping(value = "/getWarehouseById",method = RequestMethod.GET)
    @ResponseBody
    public Object getWarehouseById(Integer medicineId){
        AppReturn appReturn=new AppReturn();
        try {
            Warehouse warehouse=warehouseService.getWareHouseNumByMedicineId(medicineId);
            if(warehouse!=null){
                appReturn=AppReturn.ok(warehouse);//status=200
            }else{
                appReturn=AppReturn.defeated();//status=400
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "系统发生异常", null);
        }
        return appReturn;
    }
    /*根据UID查询用户名称------------------------------*/
    @RequestMapping(value = "/getUNameByUID",method = RequestMethod.GET)
    @ResponseBody
    public Object getUNameByUID(Integer UID){
        AppReturn appReturn=new AppReturn();
        try {
            User user=userService.getUserNameByUID(UID);
            if(user!=null){
                appReturn=AppReturn.ok(user);//status=200
            }else{
                appReturn=AppReturn.defeated();//status=400
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "系统发生异常", null);
        }
        return appReturn;
    }

    /*根据药品id查询药品销售价-----------*/
    @RequestMapping(value = "/getMedicineNameByMedicineId",method = RequestMethod.GET)
    @ResponseBody
    public Object getMedicienNameByMeidicineId(Integer medicineId){
        AppReturn appReturn=new AppReturn();
        try {
            Medicine medicine=medicineService.getSalesPriceByMedicineId(medicineId);
            if(medicine!=null){
                appReturn=AppReturn.ok(medicine);//status=200
            }else{
                appReturn=AppReturn.defeated();//status=400
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "系统发生异常", null);
        }
        return appReturn;
    }
    /*查询所有的药品单位信息--------------*/
    @RequestMapping(value = "/getAllUnitName",method = RequestMethod.GET)
    @ResponseBody
    public Object getAllUnitName(){
        AppReturn appReturn=new AppReturn();
        try {
            List<Unit> unitList=unitService.getAllUnitName();
            if(unitList.size()>0){
                appReturn=AppReturn.ok(unitList);//status=200
            }else{
                appReturn=AppReturn.defeated();//status=400
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "系统发生异常", null);
        }
        return appReturn;
    }
    /*根据药品id查询柜台是否存在数据*/
    @RequestMapping(value = "/getExsistByMedicineId",method = RequestMethod.GET)
    @ResponseBody
    public Object getExsistByMedicineId(Integer MedicineId){
        AppReturn appReturn=new AppReturn();
        try {
            Counter counter=counterService.getIsExistByMedicineId(MedicineId);
            if(counter!=null){
                appReturn=AppReturn.ok(counter);//status=200
            }else{
                appReturn=AppReturn.defeated();//status=400
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "系统发生异常", null);
        }
        return appReturn;
    }
    /*--------------------------------------查询所有柜台信息*/
    /**
     * 查询所有货位名称
     */
    @RequestMapping("/getAllMedicineNameByCounter")
    @ResponseBody
    public Object getAllMedicineName(){
        AppReturn appReturn=new AppReturn();
        try {
            List<Counter> list=counterService.getAllMedicineName();
            if(list.size()>0){
                appReturn=AppReturn.ok(list);//status=200
            }else{
                appReturn=AppReturn.defeated();//status=400
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "系统发生异常", null);
        }
        return appReturn;
    }
    /*根据柜台id修改柜台数量---------------------*/
    //修改柜台基础信息
    @RequestMapping(value="/counterModifyNum",method= RequestMethod.POST)
    @ResponseBody
    public Object modifyNum(@RequestBody Counter counter){
        AppReturn appReturn=new AppReturn();
        try {

            //修改柜台数量到数据库中
            if(counterService.modifyCounterNumById(counter)>0){
                //成功
                appReturn=AppReturn.succeed();
            }else{
                //失败
                appReturn=AppReturn.defeated();
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "异常", null);
        }
        return JSON.toJSON(appReturn);
    }
}
