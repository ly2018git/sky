package com.skyhospital.service.stock.impl;


import com.skyhospital.dao.WarehouseMapper;
import com.skyhospital.pojo.Warehouse;
import com.skyhospital.service.stock.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Warehouse getWareHouseNumByMedicineId(Integer medicineId) {
        return warehouseMapper.getWareHouseNumByMedicineId(medicineId);
    }

    @Override
    public int modifyWarehouseNum(Warehouse warehouse) {
        return warehouseMapper.modifyWarehouseNum(warehouse);
    }
}
