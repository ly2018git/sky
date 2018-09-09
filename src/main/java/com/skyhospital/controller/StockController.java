package com.skyhospital.controller;

import com.alibaba.fastjson.JSON;
import com.skyhospital.pojo.Dosageforms;
import com.skyhospital.pojo.Warehouse;
import com.skyhospital.service.stock.WarehouseService;
import com.skyhospital.tools.AppReturn;
import com.skyhospital.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：StockController
 * 描述：库存管理、查询
 * 创建时间：2018.08.21 下午 01:37
 * 创建者: Rita
 */
@Controller
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private WarehouseService warehouseService;

    @RequestMapping("/checkStorage")
    public String checkStorage(){
        return "CheckStorage";
    }


    /**
     * 重定向到主页
     * @return
     */
    @RequestMapping(value = "/welcome.html",method = RequestMethod.POST)
    public String toDashboard(){
        return "welcome";
    }

    /**
     * 重定向到库存盘点页面
     * @return
     */
    @RequestMapping(value = "/toshowstock.html",method = RequestMethod.GET)
    public String toShowStock(){
        return "stocklist";
    }


    /**
     * 重定向到调价促销页面
     * @return
     */
    @RequestMapping(value = "/toshowadjust.html",method = RequestMethod.GET)
    public String toShowAdjust(){
        return "adjustlist";
    }


    /**
     * 重定向到有效期报警页面
     * @return
     */
    @RequestMapping(value = "/toshowwarning.html",method = RequestMethod.GET)
    public String toShowWarning(){
        return "warningview";
    }


    /**
     * 重定向到药品处理页面
     * @return
     */
    @RequestMapping(value = "/toshowdispose.html",method = RequestMethod.GET)
    public String toShowDispose(){
        return "disposelist";
    }



    /**
     * 库存盘点列表显示
     * @return
     */
    @RequestMapping(value = "/showstocklist",method = RequestMethod.POST)
    @ResponseBody
    public Object showStock(@RequestBody Map<String ,Object> map){
        AppReturn appReturn = new AppReturn();
        try {
            PageUtil pageUtil = warehouseService.getInventoryList(map);
            if (pageUtil.getList().size() > 0) {
                appReturn = AppReturn.ok(pageUtil);//status=200
            }else {
                appReturn = AppReturn.build(400, "暂无数据", pageUtil);
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn = AppReturn.build(500, "系统发生异常", null);
        }
        return JSON.toJSON(appReturn);
    }


    /**
     * 有效期报警列表显示
     * @return
     */
    @RequestMapping(value = "/showwarninglist",method = RequestMethod.POST)
    @ResponseBody
    public Object showWarning(@RequestBody Map<String ,Object> map){
        AppReturn appReturn = new AppReturn();
        try {
            PageUtil pageUtil = warehouseService.getListByValidity(map);
            if (pageUtil.getList().size() > 0) {
                appReturn = AppReturn.ok(pageUtil);//status=200
            }else {
                appReturn = AppReturn.build(400, "暂无数据", pageUtil);
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn = AppReturn.build(500, "系统发生异常", null);
        }
        return JSON.toJSON(appReturn);
    }


    /**
     * 药品处理列表显示
     * @return
     */
    @RequestMapping(value = "/showdisposelist",method = RequestMethod.POST)
    @ResponseBody
    public Object showDispose(@RequestBody Map<String ,Object> map){
        AppReturn appReturn = new AppReturn();
        try {
            PageUtil pageUtil = warehouseService.getDisposeMedicineList(map);
            if (pageUtil.getList().size() > 0) {
                appReturn = AppReturn.ok(pageUtil);//status=200
            }else {
                appReturn = AppReturn.build(400, "暂无数据", pageUtil);
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn = AppReturn.build(500, "系统发生异常", null);
        }
        return JSON.toJSON(appReturn);
    }


    /**
     * 调价促销列表显示
     * @return
     */
    @RequestMapping(value = "/showadjustlist",method = RequestMethod.POST)
    @ResponseBody
    public Object showAdjust(@RequestBody Map<String ,Object> map){
        AppReturn appReturn = new AppReturn();
        try {
            PageUtil pageUtil = warehouseService.getAdjustPriceMedicineByCondition(map);
            if (pageUtil.getList().size() > 0) {
                appReturn = AppReturn.ok(pageUtil);//status=200
            }else {
                appReturn = AppReturn.build(400, "暂无数据", pageUtil);
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn = AppReturn.build(500, "系统发生异常", null);
        }
        return JSON.toJSON(appReturn);
    }


    /**
     * 根据id查询药品信息显示
     * @return
     */
    @RequestMapping(value = "/showmedicinebyid",method = RequestMethod.GET)
    @ResponseBody
    public Object showMedicineById(Integer medicineId){
        AppReturn appReturn = new AppReturn();
        try {
            Warehouse warehouse= warehouseService.getMedicineMsgById(medicineId);
            if (warehouse !=null) {
                appReturn = AppReturn.ok(warehouse);//status=200
            }else {
                appReturn = AppReturn.build(400, "暂无数据",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn = AppReturn.build(500, "系统发生异常", null);
        }
        return JSON.toJSON(appReturn);
    }

    /**
     * 获取所有剂型
     * @return
     */
    @RequestMapping(value="/getalldos",method = RequestMethod.GET)
    @ResponseBody
    public Object getAllDos(){
        AppReturn appReturn = new AppReturn();
        try {
            List<Dosageforms> list= warehouseService.getAllDos();
            if (list.size()>0) {
                appReturn = AppReturn.ok(list);//status=200
            }else {
                appReturn = AppReturn.build(400, "暂无数据",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn = AppReturn.build(500, "系统发生异常", null);
        }
        return JSON.toJSON(appReturn);
    }


    /**
     * 修改库存盘点的药品基本信息(只允许修改数量)
     * @param number
     * @param medicineId
     * @return
     */
    @RequestMapping(value="/editmedicine",method = RequestMethod.GET)
    @ResponseBody
    public Object editMedicine(@RequestParam("number")Integer number,@RequestParam("medicineId") Integer medicineId){
        AppReturn appReturn = new AppReturn();
        try {
            int isok= warehouseService.modifyMedicineMessage(number,medicineId);
            if (isok>0) {
                appReturn = AppReturn.succeed();//status=200
            }else {
                appReturn = AppReturn.build(400, "暂无数据",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn = AppReturn.build(500, "系统发生异常", null);
        }
        return JSON.toJSON(appReturn);
    }


    /**
     * 调价
     * 来自UC0205
     * @param item
     * @param discount
     * @return
     */
    @RequestMapping(value="/changeprice",method = RequestMethod.GET)
    @ResponseBody
    public Object editMedicine(@RequestParam(value = "item[]")Integer [] item, @RequestParam("discount")double discount){
        AppReturn appReturn = new AppReturn();
        try {
            int isok= warehouseService.modifyMedicinePrice(item,discount);
            if (isok>0) {
                appReturn = AppReturn.succeed();//status=200
            }else {
                appReturn = AppReturn.build(400, "暂无数据",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn = AppReturn.build(500, "系统发生异常", null);
        }
        return JSON.toJSON(appReturn);
    }


}
