package com.skyhospital.service.stock;

import com.skyhospital.tools.PageUtil;

import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：SaitemService
 * 描述：入/出库详情-业务层
 * 创建时间：2018.08.06 上午 11:39
 * 创建者: Amy
 */
public interface SaitemService {
    //分页查询药品养护列表
    PageUtil findConservePage(Map<String, Object> map) throws Exception;
    //分页查询药品购进记录列表
    PageUtil findPurchasePage(Map<String, Object> map)throws Exception;



}
