package com.skyhospital.service.sales.impl;

import com.skyhospital.dao.SellitemMapper;
import com.skyhospital.pojo.Sellitem;
import com.skyhospital.service.sales.SellitemService;
import com.skyhospital.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：SellitemServiceImpl
 * 描述：销售明细-业务实现
 * 创建时间：2018.08.06 上午 11:55
 * 创建者: Amy
 */
@Service("SellItemService")
public class SellitemServiceImpl implements SellitemService{
    @Autowired
    private SellitemMapper sellitemMapper;


    @Override
    public PageUtil findDetailPage(Map<String, Object> map) throws Exception {
        //分页工具类
        PageUtil<Sellitem> pageUtil=new PageUtil<>();
        Integer pageIndex=Integer.valueOf(map.get("pageIndex").toString());
        Integer pageSize=Integer.valueOf(map.get("pageSize").toString());
        //计算SQL语句limit的条件
        map.put("pageIndex", (pageIndex-1)*pageSize);
        List<Sellitem> list=sellitemMapper.findDetailPage(map);
        //分页数据
        pageUtil.setList(list);
        //当前页数
        pageUtil.setPageIndex(pageIndex);
        //当前每页数量
        pageUtil.setPageSize(pageSize);
        //总数量
        pageUtil.setTotalCount(sellitemMapper.findDetailCount(map));
        return pageUtil;
    }

    @Override
    @Transactional(readOnly = true)
    public PageUtil findSellItem(Map<String, Object> map) throws Exception {
        //分页工具类
        PageUtil<Sellitem> pageUtil=new PageUtil<>();
        Integer pageIndex=Integer.valueOf(map.get("pageIndex").toString());
        Integer pageSize=Integer.valueOf(map.get("pageSize").toString());
        //计算SQL语句limit的条件
        map.put("pageIndex", (pageIndex-1)*pageSize);
        List<Sellitem> list=sellitemMapper.findSellItem(map);
        //分页数据
        pageUtil.setList(list);
        //当前页数
        pageUtil.setPageIndex(pageIndex);
        //当前每页数量
        pageUtil.setPageSize(pageSize);
        //总数量
        pageUtil.setTotalCount(sellitemMapper.findSellItemCount(map));
        return pageUtil;
    }

    @Override
    public int addSellItem(Sellitem sellitem) {
        return sellitemMapper.addSellItem(sellitem);
    }
}
