package com.skyhospital.controller;

import com.alibaba.fastjson.JSON;
import com.skyhospital.pojo.User;
import com.skyhospital.service.user.UserService;
import com.skyhospital.tools.AppReturn;
import com.skyhospital.tools.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.util.DigestUtils;

/**
 * 项目名：skyhospital
 * 类名：LoginController
 * 描述：登录、注销
 * 创建时间：2018.08.21 下午 01:36
 * 创建者: Rita
 */
@Controller
public class LoginController {


}
