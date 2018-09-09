package com.skyhospital.dao;

import com.skyhospital.pojo.Shift;

public interface ShiftMapper {
    //销售员交班
    int addShift(Shift shift);
}