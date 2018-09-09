package com.skyhospital.dao;

import com.skyhospital.pojo.Unit;

import java.util.List;

public interface UnitMapper {
    //查询所有药品单位
    List<Unit> getAllUnitName();
}