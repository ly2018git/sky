package com.skyhospital.service.user;

import com.skyhospital.pojo.Vip;
import com.skyhospital.tools.PageUtil;

import java.util.List;
import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：VipService
 * 描述：会员-业务层
 * 创建时间：2018.08.06 上午 11:59
 * 创建者: Amy
 */
public interface VipService {
    //查询所有会员
    List<Vip> getAllVip();
    //分页查询会员管理列表
    PageUtil findVipPage(Map<String, Object> map) throws Exception;

    //添加会员
    int addVip(Vip vip);

    //根据vipId查找对应信息
    Vip getVipByVipId(Integer id);

    //根据会员id修改会员积分
    int modifyVipIntegral(Vip vip);

    //根据id修改会员
    int modifyVip(Vip vip);
    //根据id删除会员
    int delVip(Integer id);
    //批量删除会员
    int delVips(Integer[] item);
}
