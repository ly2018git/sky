package com.skyhospital.service.user.impl;

import com.skyhospital.dao.ShiftMapper;
import com.skyhospital.pojo.Shift;
import com.skyhospital.service.user.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 项目名：skyhospital
 * 类名：ShiftServiceImpl
 * 描述：收银员-业务实现
 * 创建时间：2018.08.06 上午 11:55
 * 创建者: Amy
 */
@Service("ShiftService")
public class ShiftServiceImpl implements ShiftService{
    @Autowired
    private ShiftMapper shiftMapper;

    @Override
    public int addShift(Shift shift) {
        return shiftMapper.addShift(shift);
    }
}
