package com.skyhospital.service.drug;

import com.skyhospital.pojo.Unit;

import java.util.List;

/**
 * 项目名：skyhospital
 * 类名：UnitService
 * 描述：药品单位-业务层
 * 创建时间：2018.08.06 上午 11:58
 * 创建者: Amy
 */
public interface UnitService {
    //查询所有药品单位
    List<Unit> getAllUnitName();
}
