package com.skyhospital.service.user.impl;

import com.skyhospital.dao.SellaccountMapper;
import com.skyhospital.dao.VipMapper;
import com.skyhospital.pojo.Sellaccount;
import com.skyhospital.pojo.Vip;
import com.skyhospital.service.user.VipService;
import com.skyhospital.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：VipServiceImpl
 * 描述：会员-业务实现
 * 创建时间：2018.08.06 上午 11:59
 * 创建者: Amy
 */
@Service("VipService")
public class VipServiceImpl implements VipService{
    @Autowired
    private VipMapper vipMapper;
    @Autowired
    private SellaccountMapper sellaccountMapper;

    @Override
    public List<Vip> getAllVip() {
        return vipMapper.getAllVip();
    }

    @Override
    @Transactional(readOnly = true)
    public PageUtil findVipPage(Map<String, Object> map) throws Exception {
        //分页工具类
        PageUtil<Vip> pageUtil=new PageUtil<>();
        Integer pageIndex=Integer.valueOf(map.get("pageIndex").toString());
        Integer pageSize=Integer.valueOf(map.get("pageSize").toString());
        //计算SQL语句limit的条件
        map.put("pageIndex", (pageIndex-1)*pageSize);
        List<Vip> list=vipMapper.findVipPage(map);
        //分页数据
        pageUtil.setList(list);
        //当前页数
        pageUtil.setPageIndex(pageIndex);
        //当前每页数量
        pageUtil.setPageSize(pageSize);
        //总数量
        pageUtil.setTotalCount(vipMapper.findVipCount(map));
        return pageUtil;
    }




    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public int addVip(Vip vip) {
        return vipMapper.addVip(vip);
    }
    //根据vipid查找对应信息
    @Override
    public Vip getVipByVipId(Integer id) {
        return vipMapper.getVipByVipId(id);
    }

    @Override
    public int modifyVipIntegral(Vip vip) {
        return vipMapper.modifyVipIntegral(vip);
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public int modifyVip(Vip vip) {
        return vipMapper.modifyVip(vip);
    }
    //删除
    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public int delVip(Integer id) {
        //先查找出所有的销售账单信息
        Sellaccount sellaccount=sellaccountMapper.getSellAccountByVipId(id);
        if(sellaccount!=null) {
            //然后修改sellaccount中的vipId的信息
            sellaccountMapper.modifyVipIdBySellAccountId(sellaccount.getSellAccountId());
        }
        return vipMapper.delVip(id);
    }
    //批量删除
    @Override
    public int delVips(Integer[] item) {
        //遍历数组
        for(Integer vipId:item){
            //先查找出所有的销售账单信息
            Sellaccount sellaccount=sellaccountMapper.getSellAccountByVipId(vipId);
            if(sellaccount!=null) {
                //然后修改sellaccount中的vipId的信息
                sellaccountMapper.modifyVipIdBySellAccountId(sellaccount.getSellAccountId());
            }
        }
        return vipMapper.delVips(item);
    }
}
