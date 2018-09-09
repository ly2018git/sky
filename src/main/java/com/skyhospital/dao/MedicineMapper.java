package com.skyhospital.dao;

import com.skyhospital.pojo.Medicine;

import java.util.List;

public interface MedicineMapper {

    /**
     * 添加药品
     * UC0401
     *
     * @param medicine
     * @return
     */
    int addMedicine(Medicine medicine);
    //查出所有药品信息
    List<Medicine> findAllMedicine();
    //根据药品id查出药品销售价格
    Medicine getSalesPriceByMedicineId(Integer medicineId);
}