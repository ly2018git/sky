package com.skyhospital.service.user.impl;

import com.skyhospital.dao.RoleMapper;
import com.skyhospital.pojo.Role;
import com.skyhospital.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名：skyhospital
 * 类名：RoleServiceImpl
 * 描述：角色-业务实现
 * 创建时间：2018.08.06 上午 11:53
 * 创建者: Amy
 */
@Service("RoleService")
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> findAllRole() {
        return roleMapper.findAllRole();
    }
}
