package com.skyhospital.dao;

import com.skyhospital.pojo.Role;

import java.util.List;

public interface RoleMapper {
    /*查询所有角色*/
    List<Role> findAllRole();
}