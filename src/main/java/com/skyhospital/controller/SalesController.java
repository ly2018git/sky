package com.skyhospital.controller;

import com.alibaba.fastjson.JSON;
import com.skyhospital.service.drug.MedicineService;
import com.skyhospital.service.sales.SellitemService;
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
 * 类名：SalesController
 * 描述：销售管理
 * 创建时间：2018.08.21 下午 01:37
 * 创建者: Rita
 */
@Controller
/*@RequestMapping("sales")*/
public class SalesController {
    @Autowired
    private SellitemService sellitemService;

    /**
     * 重定向到药品字典页面
     * @return
     */
    @RequestMapping(value = "/toshowdictionaries.html",method = RequestMethod.GET)
    public String toShowWarning(){
        return "dictionariesview";
    }

    /**
     * 药品字典列表显示
     * @return
     */
    @RequestMapping(value = "/showdictionaries",method = RequestMethod.POST)
    @ResponseBody
    public Object showDispose(@RequestBody Map<String ,Object> map){
        AppReturn appReturn = new AppReturn();
        try {
            PageUtil pageUtil = sellitemService.getMedicineList(map);
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
}
