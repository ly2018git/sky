package com.skyhospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目名：skyhospital
 * 类名：StockController
 * 描述：库存管理、查询
 * 创建时间：2018.08.21 下午 01:37
 * 创建者: Rita
 */
@Controller
//@RequestMapping("stock")
public class StockController {
    @RequestMapping("/checkStorage")
    public String checkStorage(){
        return "CheckStorage";
    }
}
