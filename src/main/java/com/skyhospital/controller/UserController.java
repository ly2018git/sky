package com.skyhospital.controller;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.StringUtils;
import com.skyhospital.pojo.Counter;
import com.skyhospital.pojo.Role;
import com.skyhospital.service.user.RoleService;
import com.skyhospital.service.user.UserService;
import com.skyhospital.tools.AppReturn;
import com.skyhospital.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//导入spring的MD5包
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：UserController
 * 描述：用户管理
 * 创建时间：2018.08.21 下午 01:36
 * 创建者: Rita
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    /*跳转到人事列表页面*/
    @RequestMapping(value="/userList")
    public String userListPage(){
        return "userList";
    }
    /*查询所有角色---------------*/
    @RequestMapping("/getAllRole")
    @ResponseBody
    public Object getGoodsallocation(){
        AppReturn appReturn=new AppReturn();
        try {
            List<Role> list= roleService.findAllRole();
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

    /*分页查询人事列表*/
    @RequestMapping(value="/getuserPage",method= RequestMethod.POST)
    @ResponseBody
    public Object getCounterInfoPage(@RequestBody Map<String, Object> map){
        AppReturn appReturn=new AppReturn();
        PageUtil<Counter> pageUtil=new PageUtil<>();
        try {
            pageUtil=userService.findUserPage(map);
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
