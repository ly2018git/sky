package com.skyhospital.dao;

import com.skyhospital.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 用户登录
     *
     * @param userName 用户名 唯一的
     * @return 用户信息
     */
    User login(String userName);

    /**
     * 添加用户信息
     *
     * @param user 要添加的用户信息
     * @return SQL执行结果
     */
    int addUser(User user);

    /**
     * 修改用户信息
     *
     * @param user 用户要修改的信息
     * @return SQL执行结果
     */
    int modifyUser(User user);

    /**
     * 删除用户
     * @param id 用户id
     * @return
     */
    int deleteUser(Integer id);

    /**
     * 修改用户密码
     * @param rnewpwd 要修改的密码
     * @return SQL执行结果
     */
    int modifyUserPassword(@Param(value = "UId") String UId,@Param(value = "rnewpwd") String rnewpwd);

    /**
     * 修改用户角色
     * @param id 角色id
     * @return SQL执行结果
     */
    int modifyRole(Integer id);

    /**
     * 根据id去查询密码
     * @param UId 用户id
     * @return
     */
    String findPwd(String UId);

    //根据用户id查询销售员姓名
    User getUserNameByUID(Integer UID);
    //分页查询人事列表
    List<User> findUserPage(Map<String, Object> map);

    //分页查询人事列表总记录数
    int findUserCount(Map<String, Object> map)throws Exception;

}