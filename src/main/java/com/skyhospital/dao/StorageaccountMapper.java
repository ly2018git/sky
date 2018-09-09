package com.skyhospital.dao;

import com.skyhospital.pojo.Sellaccount;
import com.skyhospital.pojo.Storageaccount;

public interface StorageaccountMapper {


    /**
     * 药品出/入库
     * UC0402/UC0403
     * @param sellaccount
     * @return
     */
    int addStorageaccount(Storageaccount storageaccount);

    /**
     * 出入库账单的结算时间
     * @param storageaccount
     * @return
     */
    int modifyStorageaccountByClosingDate(Storageaccount storageaccount);


}