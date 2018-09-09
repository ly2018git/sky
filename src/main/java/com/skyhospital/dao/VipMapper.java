package com.skyhospital.dao;

import com.skyhospital.pojo.Vip;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface VipMapper {
    //查询所有会员
    List<Vip> getAllVip();
    //分页查询会员管理列表
    List<Vip> findVipPage(Map<String, Object> map);

    //分页查询会员管理列表总记录数
    int findVipCount(Map<String, Object> map)throws Exception;

    //添加会员
    int addVip(Vip vip);

    //根据vipId查找对应信息
    Vip getVipByVipId(Integer id);

    //根据会员id修改会员积分
    int modifyVipIntegral(Vip vip);
    //修改会员
    int modifyVip(Vip vip);
    //删除会员
    int delVip(Integer id);
    //批量删除会员
    int delVips(@Param("item") Integer[] item);
}