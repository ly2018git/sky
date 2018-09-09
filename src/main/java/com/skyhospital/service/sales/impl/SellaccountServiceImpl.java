package com.skyhospital.service.sales.impl;

import com.skyhospital.dao.SellaccountMapper;
import com.skyhospital.pojo.Sellaccount;
import com.skyhospital.service.sales.SellaccountService;
import com.skyhospital.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：SellaccountServiceImpl
 * 描述：销售账单-业务实现
 * 创建时间：2018.08.06 上午 11:54
 * 创建者: Amy
 */
@Service("SellAccountService")
public class SellaccountServiceImpl implements SellaccountService{
    @Autowired
    private SellaccountMapper sellaccountMapper;

    @Override
    @Transactional(readOnly=false,propagation= Propagation.REQUIRED)
    public int addSellCount(Sellaccount sellaccount) {

        return sellaccountMapper.addSellCount(sellaccount);
    }

    @Override
    @Transactional(readOnly = true)
    public PageUtil findSaleTurnover(Map<String, Object> map) throws Exception {
//分页工具类
        //PageUtil pageUtil=new PageUtil(list);
        PageUtil<Sellaccount> pageUtil=new PageUtil<>();
        Integer pageIndex=Integer.valueOf(map.get("pageIndex").toString());
        Integer pageSize=Integer.valueOf(map.get("pageSize").toString());
        //计算SQL语句limit的条件
        map.put("pageIndex", (pageIndex-1)*pageSize);
        List<Sellaccount> list=sellaccountMapper.findSaleTurnover(map);
        //分页数据
        pageUtil.setList(list);
        //当前页数
        pageUtil.setPageIndex(pageIndex);
        //当前每页数量
        pageUtil.setPageSize(pageSize);
        //总数量
        pageUtil.setTotalCount(sellaccountMapper.findSellAccountCount(map));
        return pageUtil;
    }

}
