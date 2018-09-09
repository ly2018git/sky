package com.skyhospital.service.sales;

import com.skyhospital.pojo.Counter;
import com.skyhospital.tools.PageUtil;

import java.util.List;
import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：CounterService
 * 描述：柜台管理-业务层
 * 创建时间：2018.08.06 上午 11:39
 * 创建者: Amy
 */
public interface CounterService {
    //查询所有柜台信息
    List<Counter> getAllMedicineName();
    //根据柜台id修改柜台数量
    int modifyCounterNumById(Counter counter);
    //根据药品id查询是否存在数据
    Counter getIsExistByMedicineId(Integer MedicineId);
    //分页查询柜台销售列表
    /*List<Counter> findCounterPage(String medicineName, Integer pageIndex, Integer pageSize);*/
    PageUtil findCounterPage(Map<String, Object> map);

    //添加柜台药品销售
    boolean addCounter(Counter counter)throws Exception;
    //根据柜台id查询柜台信息
    Counter getCounterMsgById(Integer counterId);
    //修改柜台药品销售
    int modifyCounter(Counter counter);
    //删除柜台药品销售计划
    int delCounter(Counter counter);
}
