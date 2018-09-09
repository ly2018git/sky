package com.skyhospital.service.stock.impl;

import com.skyhospital.dao.SaitemMapper;
import com.skyhospital.pojo.Saitem;
import com.skyhospital.service.stock.SaitemService;
import com.skyhospital.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：SaitemServiceImpl
 * 描述：入/出库详情-业务实现
 * 创建时间：2018.08.06 上午 11:39
 * 创建者: Amy
 */
@Service
public class SaitemServiceImpl implements SaitemService {

    @Autowired
    private SaitemMapper saitemMapper;

    //药品养护
    @Override
    public PageUtil findConservePage(Map<String, Object> map) throws Exception {
        //分页工具类
        PageUtil<Saitem> pageUtil=new PageUtil<>();
        Integer pageIndex=Integer.valueOf(map.get("pageIndex").toString());
        Integer pageSize=Integer.valueOf(map.get("pageSize").toString());
        //计算SQL语句limit的条件
        map.put("pageIndex", (pageIndex-1)*pageSize);
        List<Saitem> list=saitemMapper.findConservePage(map);
        //分页数据
        pageUtil.setList(list);
        //当前页数
        pageUtil.setPageIndex(pageIndex);
        //当前每页数量
        pageUtil.setPageSize(pageSize);
        //总数量
        pageUtil.setTotalCount(saitemMapper.findConserveCount(map));
        return pageUtil;
    }
    //药品购进表
    @Override
    public PageUtil findPurchasePage(Map<String, Object> map) throws Exception {
        //分页工具类
        PageUtil<Saitem> pageUtil=new PageUtil<>();
        Integer pageIndex=Integer.valueOf(map.get("pageIndex").toString());
        Integer pageSize=Integer.valueOf(map.get("pageSize").toString());
        //计算SQL语句limit的条件
        map.put("pageIndex", (pageIndex-1)*pageSize);
        List<Saitem> list=saitemMapper.findPurchasePage(map);
        //分页数据
        pageUtil.setList(list);
        //当前页数
        pageUtil.setPageIndex(pageIndex);
        //当前每页数量
        pageUtil.setPageSize(pageSize);
        //总数量
        pageUtil.setTotalCount(saitemMapper.findPurchaseCount(map));
        return pageUtil;
    }

}
