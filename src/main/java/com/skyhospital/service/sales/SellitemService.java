package com.skyhospital.service.sales;

import com.skyhospital.pojo.Sellitem;
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
    //分页查询消费明细
    PageUtil findDetailPage(Map<String, Object> map)throws  Exception;

    //根据药品名称和销售日期时间段分页查询药品销售列表
    PageUtil findSellItem(Map<String, Object> map)throws Exception;
    //添加销售详情
    int addSellItem(Sellitem sellitem);
}
