package com.skyhospital.service.drug;

import com.skyhospital.pojo.Medicine;

import java.util.List;

/**
 * 项目名：skyhospital
 * 类名：MedicineService
 * 描述：药品-业务层
 * 创建时间：2018.08.06 上午 11:49
 * 创建者: Amy
 */
public interface MedicineService {
    //查出所有药品信息
    List<Medicine> findAllMedicine();
    //根据药品id查出药品销售价格
    Medicine getSalesPriceByMedicineId(Integer medicineId);




}
