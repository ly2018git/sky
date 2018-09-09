package com.skyhospital.service.user;

import com.skyhospital.pojo.Role;

import java.util.List;

/**
 * 项目名：skyhospital
 * 类名：RoleService
 * 描述：角色-业务层
 * 创建时间：2018.08.06 上午 11:53
 * 创建者: Amy
 */
public interface RoleService {
    /*查询所有角色*/
    List<Role> findAllRole();
}
