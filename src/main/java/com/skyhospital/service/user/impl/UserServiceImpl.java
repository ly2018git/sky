package com.skyhospital.service.user.impl;

import com.skyhospital.dao.UserMapper;
import com.skyhospital.pojo.User;
import com.skyhospital.service.user.UserService;
import com.skyhospital.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：UserServiceImpl
 * 描述：用户-业务实现
 * 创建时间：2018.08.06 上午 11:58
 * 创建者: Amy
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserNameByUID(Integer UID) {
        return userMapper.getUserNameByUID(UID);
    }

    @Override
    public PageUtil findUserPage(Map<String, Object> map) throws Exception {
        //分页工具类
        PageUtil<User> pageUtil=new PageUtil<>();
        Integer pageIndex=Integer.valueOf(map.get("pageIndex").toString());
        Integer pageSize=Integer.valueOf(map.get("pageSize").toString());
        //计算SQL语句limit的条件
        map.put("pageIndex", (pageIndex-1)*pageSize);
        List<User> list=userMapper.findUserPage(map);
        //分页数据
        pageUtil.setList(list);
        //当前页数
        pageUtil.setPageIndex(pageIndex);
        //当前每页数量
        pageUtil.setPageSize(pageSize);
        //总数量
        pageUtil.setTotalCount(userMapper.findUserCount(map));
        return pageUtil;
    }
}
