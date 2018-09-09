package com.skyhospital.service.sales.impl;

import com.skyhospital.dao.CounterMapper;
import com.skyhospital.dao.WarehouseMapper;
import com.skyhospital.pojo.Counter;
import com.skyhospital.pojo.Warehouse;
import com.skyhospital.service.sales.CounterService;
import com.skyhospital.tools.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：CounterServiceImpl
 * 描述：柜台管理-业务实现
 * 创建时间：2018.08.06 上午 11:40
 * 创建者: Amy
 */
@Service("CounterService")
public class CounterServiceImpl implements CounterService{
    @Autowired
    private CounterMapper counterMapper;
    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public List<Counter> getAllMedicineName() {
        return counterMapper.getAllMedicineName();
    }

    @Override
    public int modifyCounterNumById(Counter counter) {
        return counterMapper.modifyCounterNumById(counter);
    }

    @Override
    public Counter getIsExistByMedicineId(Integer MedicineId) {
        return counterMapper.getIsExistByMedicineId(MedicineId);
    }

    //分页查询柜台销售计划列表
    @Override
    public PageUtil findCounterPage(Map<String, Object> map) {
        //分页工具类
        PageUtil<Counter> pageUtil=new PageUtil<>();
        Integer pageIndex=Integer.valueOf(map.get("pageIndex").toString());
        Integer pageSize=Integer.valueOf(map.get("pageSize").toString());
        //计算SQL语句limit的条件
        map.put("pageIndex", (pageIndex-1)*pageSize);
        List<Counter> list=counterMapper.findCounterPage(map);
        //分页数据
        pageUtil.setList(list);
        //当前页数
        pageUtil.setPageIndex(pageIndex);
        //当前每页数量
        pageUtil.setPageSize(pageSize);
        //总数量
        pageUtil.setTotalCount(counterMapper.findCounterCount(map));
        return pageUtil;
    }


    @Override
    public boolean addCounter(Counter counter) throws Exception{
        boolean flag=false;
        //先根据药品id查出库存中是否有药品数量
        Warehouse warehouse=warehouseMapper.getWareHouseNumByMedicineId(counter.getMedicineId());
        //添加柜台药品数量的同时修改库存信息
        if(warehouse.getNumber()!=0&&counterMapper.addCounter(counter)>0) {
            warehouse.setMedicineId(counter.getMedicineId());
            //剩余的库存数量
            int leavings=warehouse.getNumber()-counter.getNumber();
            warehouse.setNumber(leavings);
            warehouseMapper.modifyWarehouseNum(warehouse);
            flag=true;
        }
        return flag;
    }

    @Override
    public Counter getCounterMsgById(Integer counterId) {
        return counterMapper.getCounterMsgById(counterId);
    }

    @Override
    public int modifyCounter(Counter counter) {
        return counterMapper.modifyCounter(counter);
    }

    @Override
    public int delCounter(Counter counter) {
        return counterMapper.delCounter(counter);
    }

   /* @Override
    public List<Counter> findCounterPage(String medicineName, Integer pageIndex, Integer pageSize) {
        return counterMapper.findCounterPage(medicineName,(pageIndex-1)*pageSize,pageSize);
    }*/
}
