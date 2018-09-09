package com.skyhospital.dao;

import com.skyhospital.pojo.Warehouse;

public interface WarehouseMapper {

    /**
     * 根据出入库详情去修改库存信息
     * @param warehouse
     * @return
     */
    int modifyWarehouse(Warehouse warehouse);


    /**
     * 如果出入库信息审核通过了就要进行库存查找，如果没有数据就要添加
     * @param warehouse
     * @return
     */
    int addWarehouse(Warehouse warehouse);

    //根据药品id查询库存数量
    Warehouse getWareHouseNumByMedicineId(Integer medicineId);
    //根据药品id修改库存数量
    int modifyWarehouseNum(Warehouse warehouse);
}