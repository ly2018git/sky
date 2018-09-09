package com.skyhospital.service.drug.impl;

import com.skyhospital.dao.UnitMapper;
import com.skyhospital.pojo.Unit;
import com.skyhospital.service.drug.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名：skyhospital
 * 类名：UnitServiceImpl
 * 描述：药品单位-业务实现
 * 创建时间：2018.09.06 上午 11:58
 * 创建者: Amy
 */
@Service("unitService")
public class UnitServiceImpl implements UnitService{
    @Autowired
    private UnitMapper unitMapper;
    @Override
    public List<Unit> getAllUnitName() {
        return unitMapper.getAllUnitName();
    }
}
