package com.skyhospital.dao;

import com.skyhospital.pojo.Sellitem;

import java.util.List;
import java.util.Map;

public interface SellitemMapper {
    //分页查询消费明细
    List<Sellitem> findDetailPage(Map<String, Object> map);
    //分页查询消费明细总记录数
    int findDetailCount(Map<String, Object> map)throws Exception;


    //根据药品名称和销售日期时间段分页查询药品销售列表
    List<Sellitem> findSellItem(Map<String, Object> map)throws Exception;

    //分页总记录数
    int findSellItemCount(Map<String, Object> map)throws Exception;

    //添加销售详情
    int addSellItem(Sellitem sellitem);
}