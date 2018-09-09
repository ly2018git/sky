package com.skyhospital.dao;

import com.skyhospital.pojo.Saitem;

import java.util.List;
import java.util.Map;

public interface SaitemMapper {


    /**
     * 药品出/入库
     * UC0402/UC0403
     * @param saitem
     * @return
     */
    int addSaitem(Saitem saitem);


    /**
     * UC0408
     * 出入库审核
     * @param saitem
     * @return
     */
    int modifySaitemByAudit(Saitem saitem);

    //分页查询药品养护列表
    List<Saitem> findConservePage(Map<String, Object> map);
    //分页查询药品养护列表总记录数
    int findConserveCount(Map<String, Object> map)throws Exception;

    //分页查询药品购进记录列表
    List<Saitem> findPurchasePage(Map<String, Object> map);
    //分页查询药品购进记录列表总记录数
    int findPurchaseCount(Map<String, Object> map)throws Exception;

}