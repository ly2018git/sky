package com.skyhospital.dao;

import com.skyhospital.pojo.Saitem;

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

}