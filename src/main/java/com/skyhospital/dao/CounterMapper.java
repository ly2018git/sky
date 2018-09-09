package com.skyhospital.dao;

import com.skyhospital.pojo.Counter;

import java.util.List;
import java.util.Map;

public interface CounterMapper {
    //查询所有柜台信息
    List<Counter> getAllMedicineName();
    //根据柜台id修改柜台数量
    int modifyCounterNumById(Counter counter);
    //根据药品id查询是否存在数据(也可用于查询柜台id)
    Counter getIsExistByMedicineId(Integer MedicineId);

    //分页查询柜台销售计划列表

    List<Counter> findCounterPage(Map<String,Object> map);
    //分页查询柜台销售计划列表总记录数
    int findCounterCount(Map<String, Object> map);
    //添加柜台药品销售计划
    int addCounter(Counter counter);

    //根据柜台id查询柜台信息
    Counter getCounterMsgById(Integer counterId);

    //修改柜台药品销售计划
    int modifyCounter(Counter counter);
    //删除柜台药品销售计划
    int delCounter(Counter counter);
}