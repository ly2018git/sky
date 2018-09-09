package com.skyhospital.controller;

import com.alibaba.fastjson.JSON;
import com.skyhospital.pojo.Vip;
import com.skyhospital.service.user.VipService;
import com.skyhospital.tools.AppReturn;
import com.skyhospital.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：VipController
 * 描述：会员管理
 * 创建时间：2018.08.21 下午 01:39
 * 创建者: Rita
 */
@Controller
@RequestMapping("/vip")
public class VipController {
    @Autowired
    private VipService vipService;
    /*查询所有会员*/
    @RequestMapping(value="/getAllVip",method= RequestMethod.POST)
    @ResponseBody
    public Object getAllVip(){
        AppReturn appReturn=new AppReturn();
        List<Vip> viplist=vipService.getAllVip();
        try {
            if(viplist.size()>0){
                appReturn= AppReturn.ok(viplist);//status=200
            }else{
                appReturn=AppReturn.build(400, "暂无数据", viplist);//status=400
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "系统发生异常", null);
        }
        return JSON.toJSON(appReturn);
    }

    //跳转到VIP修改界面
    @RequestMapping(value="/vipModify")
    public String appInfoModify(){
        return "VipModify";
    }
    //查出要修改的所有的会员信息
    @RequestMapping(value="/getVipMsgModify")
    @ResponseBody
    public Object modifyViewAppById(@RequestParam String id){
        AppReturn appReturn=new AppReturn();
        //根据id查询user表中的数据
        Vip vip=vipService.getVipByVipId(Integer.parseInt(id));
        //传数据给前端
        try {
            if(null!=vip){
                appReturn=AppReturn.ok(vip);
            }else{
                appReturn=AppReturn.build(400, "暂无数据", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "系统发生异常", null);
        }
        return JSON.toJSON(appReturn);
    }

    //修改会员基础信息
    @RequestMapping(value="/vipModifySave",method=RequestMethod.POST)
    @ResponseBody
    public Object modifySave(@RequestBody Vip vip){
        AppReturn appReturn=new AppReturn();
        try {
            //修改人
            vip.setModifyBy(1);
            //修改时间
            vip.setModifyDate(new Date());
            //修改APP信息到数据库中
            if(vipService.modifyVip(vip)>0){
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

    //删除会员
    @RequestMapping(value="/delVip",method=RequestMethod.GET)
    @ResponseBody
    public Object delVipById(@RequestParam String id){
        AppReturn appReturn=new AppReturn();
        //根据id查询user表中的数据
        //传数据给前端
        try {
            if(vipService.delVip(Integer.parseInt(id))>0){
                appReturn=AppReturn.succeed();
            }else{
                appReturn=AppReturn.build(400, "暂无数据", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "系统发生异常", null);
        }
        return JSON.toJSON(appReturn);
    }
    //批量删除会员
    //删除会员
    @RequestMapping(value="/delVips",method=RequestMethod.GET)
    @ResponseBody
    public Object delVipById(@RequestParam(value="item[]") Integer[] item){
        AppReturn appReturn=new AppReturn();
        //根据id查询user表中的数据
        //传数据给前端
        try {
            if(vipService.delVips(item)>0){
                appReturn=AppReturn.succeed();
            }else{
                appReturn=AppReturn.build(400, "暂无数据", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            appReturn=AppReturn.build(500, "系统发生异常", null);
        }
        return JSON.toJSON(appReturn);
    }

    //跳转到会员添加页面
    @RequestMapping(value="/vipAdd")
    public String Vipadd(){
        return "VipAdd";
    }


    //执行会员添加
    @RequestMapping(value="/addVip",method=RequestMethod.POST)
    @ResponseBody
    public Object appinfoaddAdd(@RequestBody Vip vipInfo, HttpSession session, HttpServletRequest request){
        AppReturn appReturn=new AppReturn();
        try {
            //创建时间
            vipInfo.setCreateDate(new Date());
            //修改时间
            vipInfo.setModifyDate(new Date());
            //创建人
            vipInfo.setCreateBy(1);
            //新增会员信息到数据库中
            if(vipService.addVip(vipInfo)>0){
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


    //跳转到Vip管理列表页面
    @RequestMapping(value="/vipManage")
    public String VipList(){
        return "VipList";
    }

    @RequestMapping(value="/getVipInfoPage",method= RequestMethod.POST)
    @ResponseBody
    public Object getVipInfoPage(@RequestBody Map<String, Object> map){
        AppReturn appReturn=new AppReturn();
        PageUtil<Vip> pageUtil=new PageUtil<>();
        try {
            pageUtil=vipService.findVipPage(map);
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

    /*根据会员id修改柜台数量---------------------*/
    //修改会员基础信息
    @RequestMapping(value="/counterModifyVipIntegral",method= RequestMethod.POST)
    @ResponseBody
    public Object modifyVipIntegral(@RequestBody Vip vip){
        AppReturn appReturn=new AppReturn();
        try {

            //修改柜台数量到数据库中
            if(vipService.modifyVipIntegral(vip)>0){
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
