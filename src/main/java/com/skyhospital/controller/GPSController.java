package com.skyhospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    /**
     * 进入 药品购进明细报表 页面
     * 来自用例UC0103
     */
    @RequestMapping("/drugPurchaseGps")
    public String drugPurchaseGps(){
        return "drugPurchaseGps";
    }

    /**
     * 进入 药品销售明细报表 页面
     * 来自用例UC0103
     */
    @RequestMapping("/drugSalesGps")
    public String drugSales(){
        return "drugSalesGps";
    }

    /**
     * 进入 药品养护报表 页面
     * 来自用例UC0103
     */
    @RequestMapping("/drugMaintainGps")
    public String drugMaintainGps(){
        return "drugMaintainGps";
    }
}
