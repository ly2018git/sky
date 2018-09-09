package com.skyhospital.service.stock.impl;


import com.skyhospital.dao.WarehouseMapper;
import com.skyhospital.pojo.Dosageforms;
import com.skyhospital.pojo.Warehouse;
import com.skyhospital.service.stock.WarehouseService;
import com.skyhospital.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：WarehouseServiceImpl
 * 描述：仓库库存-业务实现
 * 创建时间：2018.08.06 上午 11:39
 * 创建者: Amy
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public PageUtil getDisposeMedicineList(Map<String ,Object> map) {
        //分页工具类
        PageUtil pageUtil=new PageUtil();
        Integer pageIndex=Integer.valueOf(map.get("pageIndex").toString());
        Integer pageSize=Integer.valueOf(map.get("pageSize").toString());
        //计算SQL语句limit的条件
        map.put("pageIndex", (pageIndex-1)*pageSize);
        List<Warehouse> list=warehouseMapper.getDisposeMedicineList(map);
        //分页数据
        pageUtil.setList(list);
        //当前页数
        pageUtil.setPageIndex(pageIndex);
        //当前每页数量
        pageUtil.setPageSize(pageSize);
        //总数量
        pageUtil.setTotalCount(warehouseMapper.getDisposeMedicineCount(map));
        return pageUtil;
    }

    @Override
    public int getDisposeMedicineCount(Map<String ,Object> map) {
        return warehouseMapper.getDisposeMedicineCount(map);
    }

    @Override
    public PageUtil getListByValidity(Map<String ,Object> map) {
        //分页工具类
        PageUtil pageUtil=new PageUtil();
        Integer pageIndex=Integer.valueOf(map.get("pageIndex").toString());
        Integer pageSize=Integer.valueOf(map.get("pageSize").toString());
        //计算SQL语句limit的条件
        map.put("pageIndex", (pageIndex-1)*pageSize);
        List<Warehouse> list=warehouseMapper.getListByValidity(map);
        //分页数据
        pageUtil.setList(list);
        //当前页数
        pageUtil.setPageIndex(pageIndex);
        //当前每页数量
        pageUtil.setPageSize(pageSize);
        //总数量
        pageUtil.setTotalCount(warehouseMapper.getCountByValidity(map));
        return pageUtil;
    }

    @Override
    public int getCountByValidity(Map<String ,Object> map) {
        return warehouseMapper.getCountByValidity(map);
    }


    @Override
    public int modifyMedicinePrice(Integer[] item,double discount) {
        int isok=warehouseMapper.modifyMedicinePrice(item,discount);
        System.out.println(isok);
        return isok;
    }


    @Override
    public PageUtil getAdjustPriceMedicineByCondition(Map<String, Object> map) {
        //分页工具类
        PageUtil pageUtil=new PageUtil();
        Integer pageIndex=Integer.valueOf(map.get("pageIndex").toString());
        Integer pageSize=Integer.valueOf(map.get("pageSize").toString());
        //计算SQL语句limit的条件
        map.put("pageIndex", (pageIndex-1)*pageSize);
        List<Warehouse> list=warehouseMapper.getAdjustPriceMedicineByCondition(map);
        //分页数据
        pageUtil.setList(list);
        //当前页数
        pageUtil.setPageIndex(pageIndex);
        //当前每页数量
        pageUtil.setPageSize(pageSize);
        //总数量
        pageUtil.setTotalCount(warehouseMapper.getCountByAPMedicine(map));
        return pageUtil;
    }

    @Override
    public int getCountByAPMedicine(Map<String,Object> map) {
        return warehouseMapper.getCountByAPMedicine(map);
    }

    @Override
    public Warehouse getMedicineMsgById(Integer medicineId) {
        return warehouseMapper.getMedicineMsgById(medicineId);
    }

    @Override
    public List<Dosageforms> getAllDos() {
        return warehouseMapper.getAllDos();
    }

    @Override
    public int modifyMedicineMessage(Integer number,Integer medicineId) {
        return warehouseMapper.modifyMedicineMessage(number,medicineId);
    }

    @Override
    public PageUtil getInventoryList(Map<String, Object> map) {
        //分页工具类
        PageUtil pageUtil=new PageUtil();
        Integer pageIndex=Integer.valueOf(map.get("pageIndex").toString());
        Integer pageSize=Integer.valueOf(map.get("pageSize").toString());
        //计算SQL语句limit的条件
        map.put("pageIndex", (pageIndex-1)*pageSize);
        List<Warehouse> list=warehouseMapper.getInventoryList(map);
        //分页数据
        pageUtil.setList(list);
        //当前页数
        pageUtil.setPageIndex(pageIndex);
        //当前每页数量
        pageUtil.setPageSize(pageSize);
        //总数量
        pageUtil.setTotalCount(warehouseMapper.getCountByInventory(map));
        return pageUtil;
    }

    @Override
    public int getCountByInventory(Map<String, Object> map) {

        return warehouseMapper.getCountByValidity(map);
    }
}
