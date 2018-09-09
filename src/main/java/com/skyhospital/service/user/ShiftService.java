package com.skyhospital.service.user;

import com.skyhospital.pojo.Shift;

/**
 * 项目名：skyhospital
 * 类名：ShiftService
 * 描述：收银员-业务层
 * 创建时间：2018.08.06 上午 11:55
 * 创建者: Amy
 */
public interface ShiftService {
    //销售员交班
    int addShift(Shift shift);
}
