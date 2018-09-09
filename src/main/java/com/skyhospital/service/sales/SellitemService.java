package com.skyhospital.service.sales;

import com.skyhospital.tools.PageUtil;

import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：SellitemService
 * 描述：销售明细-业务层
 * 创建时间：2018.08.06 上午 11:54
 * 创建者: Amy
 */
public interface SellitemService {
    /**
     * 查询药品字典
     * 来自UC0501
     * @param map
     * @return
     */
    PageUtil getMedicineList(Map<String ,Object> map);

    /**
     * 获取药品字典查询总条数
     * 来自UC0501
     * @param map
     * @return
     */
    int getMedicineCount(Map<String ,Object> map);
}
