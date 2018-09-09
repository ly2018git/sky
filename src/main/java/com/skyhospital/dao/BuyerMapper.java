package com.skyhospital.dao;

import com.skyhospital.pojo.Buyer;

import java.util.List;
import java.util.Map;

public interface BuyerMapper {


    /**
     * UC0404
     * 供应商添加
     * @param
     *
     */
    int addBuyer(Buyer buyer);


    /**
     *UC0405
     * 供应商管理显示
     * 根据供货单位名称  SupplierName
     * 该供应商的状态    State
     * 当前是多少页      Pageindex
     * 一页显示多少行     Pagesize
     * @return
     */
    List<Buyer> getBuyerList(Map<String,Object> map);


    /**
     * UC0405
     * 供应商管理总数
     * 根据供货单位名称  SupplierName
     * 该供应商的状态    State
     * @param map
     * @return
     */
    int getBuyerCount(Map<String, Object> map);


    /**
     * UC0405
     * 供应商管理————修改供应商,删除供应商
     * @param
     * @return
     */
    int modifyBuyer(Buyer buyer);





}