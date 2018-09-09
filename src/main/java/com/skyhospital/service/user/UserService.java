package com.skyhospital.service.user;

import com.skyhospital.pojo.User;
import com.skyhospital.tools.PageUtil;

import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：UserService
 * 描述：用户-业务层
 * 创建时间：2018.08.06 上午 11:58
 * 创建者: Amy
 */
public interface UserService {
    //根据用户id查询销售员姓名
    User getUserNameByUID(Integer UID);
    //分页查询人事列表
    PageUtil findUserPage(Map<String, Object> map)throws  Exception;
}
