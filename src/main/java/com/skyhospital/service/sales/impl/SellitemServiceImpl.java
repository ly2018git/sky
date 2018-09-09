package com.skyhospital.service.sales.impl;

import com.skyhospital.dao.MedicineMapper;
import com.skyhospital.pojo.Medicine;
import com.skyhospital.service.sales.SellitemService;
import com.skyhospital.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：SellitemServiceImpl
 * 描述：销售明细-业务实现
 * 创建时间：2018.08.06 上午 11:55
 * 创建者: Amy
 */
@Service
public class SellitemServiceImpl implements SellitemService{

    @Autowired
    private MedicineMapper medicineMapper;

    @Override
    public PageUtil getMedicineList(Map<String ,Object> map) {
        //分页工具类
        PageUtil pageUtil=new PageUtil();
        Integer pageIndex=Integer.valueOf(map.get("pageIndex").toString());
        Integer pageSize=Integer.valueOf(map.get("pageSize").toString());
        //计算SQL语句limit的条件
        map.put("pageIndex", (pageIndex-1)*pageSize);
        List<Medicine> list=medicineMapper.getMedicineList(map);
        //分页数据
        pageUtil.setList(list);
        //当前页数
        pageUtil.setPageIndex(pageIndex);
        //当前每页数量
        pageUtil.setPageSize(pageSize);
        //总数量
        pageUtil.setTotalCount(medicineMapper.getMedicineCount(map));
        return pageUtil;
    }

    @Override
    public int getMedicineCount(Map<String ,Object> map) {
        return medicineMapper.getMedicineCount(map);
    }
}
