package com.skyhospital.service.drug.impl;

import com.skyhospital.dao.MedicineMapper;
import com.skyhospital.pojo.Medicine;
import com.skyhospital.service.drug.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名：skyhospital
 * 类名：MedicineServiceImpl
 * 描述：药品-业务实现
 * 创建时间：2018.08.06 上午 11:49
 * 创建者: Amy
 */
@Service
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    private MedicineMapper medicineMapper;
    @Override
    public List<Medicine> findAllMedicine() {
        return medicineMapper.findAllMedicine();
    }

    @Override
    public Medicine getSalesPriceByMedicineId(Integer medicineId) {
        return medicineMapper.getSalesPriceByMedicineId(medicineId);
    }
}
