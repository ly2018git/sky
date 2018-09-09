package com.skyhospital.service.stock;

import com.skyhospital.pojo.Warehouse;

/**
 * 项目名：skyhospital
 * 类名：WarehouseServiceImpl
 * 描述：仓库库存-业务层
 * 创建时间：2018.08.06 上午 11:39
 * 创建者: Amy
 */
public interface WarehouseService {

    //根据药品id查询库存数量
    Warehouse getWareHouseNumByMedicineId(Integer medicineId);
    //根据药品id修改库存数量
    int modifyWarehouseNum(Warehouse warehouse);


}
