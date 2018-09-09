package com.skyhospital.controller;

import com.alibaba.fastjson.JSON;
import com.skyhospital.pojo.Counter;
import com.skyhospital.service.sales.SellitemService;
import com.skyhospital.service.stock.SaitemService;
import com.skyhospital.tools.AppReturn;
import com.skyhospital.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：GPSController
 * 描述：GPS报表
 * 创建时间：2018.08.21 下午 01:37
 * 创建者: Amy
 */
@Controller
@RequestMapping("gps")
public class GPSController {
    @Autowired
    private SellitemService sellItemService;
    @Autowired
    private SaitemService saitemService;


    /*跳转到销售明细列表页面*/
    @RequestMapping(value="/drugSalesGpsList")
    public String DrugSalesListPage(){
        return "drugSalesGps";
    }
    /*跳转到药品养护列表页面*/
    @RequestMapping(value="/drugMaintainGpsList")
    public String DrugMaintainGpsListPage(){
        return "drugMaintainGps";
    }
    /*跳转到药品购进列表页面*/
    @RequestMapping(value="/drugPurchaseGpsList")
    public String DrugPurchaseGpsListPage(){
        return "drugPurchaseGps";
    }

    /*分页查询销售明细列表*/
    @RequestMapping(value="/getdrugSalesGpsInfoPage",method= RequestMethod.POST)
    @ResponseBody
    public Object getCounterInfoPage(@RequestBody Map<String, Object> map){
        AppReturn appReturn=new AppReturn();
        PageUtil<Counter> pageUtil=new PageUtil<>();
        try {
            pageUtil=sellItemService.findDetailPage(map);
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
    /*分页查询购进记录列表*/
    @RequestMapping(value="/getPurchaseInfoPage",method= RequestMethod.POST)
    @ResponseBody
    public Object getPurchasePage(@RequestBody Map<String, Object> map){
        AppReturn appReturn=new AppReturn();
        PageUtil<Counter> pageUtil=new PageUtil<>();
        try {
            pageUtil=saitemService.findPurchasePage(map);
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
    /*分页查询药品养护列表*/
    @RequestMapping(value="/getMaitainInfoPage",method= RequestMethod.POST)
    @ResponseBody
    public Object getMaitainPage(@RequestBody Map<String, Object> map){
        AppReturn appReturn=new AppReturn();
        PageUtil<Counter> pageUtil=new PageUtil<>();
        try {
            pageUtil=saitemService.findConservePage(map);
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
}
