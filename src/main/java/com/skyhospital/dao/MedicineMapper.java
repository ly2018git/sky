package com.skyhospital.dao;

import com.skyhospital.pojo.Medicine;

import java.util.List;
import java.util.Map;

public interface MedicineMapper {

    /**
     * 添加药品
     * UC0401
     *
     * @param medicine
     * @return
     */
    int addMedicine(Medicine medicine);

    /**
     * 查询药品字典
     * 来自UC0501
     * @param map
     * @return
     */
    List<Medicine> getMedicineList(Map<String ,Object> map);

    /**
     * 获取药品字典查询总条数
     * 来自UC0501
     * @param map
     * @return
     */
    int getMedicineCount(Map<String ,Object> map);

}