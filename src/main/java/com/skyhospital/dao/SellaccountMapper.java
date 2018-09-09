package com.skyhospital.dao;


import com.skyhospital.pojo.Sellaccount;

import java.util.List;
import java.util.Map;

public interface SellaccountMapper {



    //添加销售药品
    int addSellCount(Sellaccount sellaccount);

    //销售营业额分页查询
    List<Sellaccount> findSaleTurnover(Map<String, Object> map) throws Exception;

    //销售营业额查询总记录数
    int findSellAccountCount(Map<String, Object> map) throws Exception;

    //根据vipid查找账单记录
    Sellaccount getSellAccountByVipId(Integer vipId);

    //根据账单号修改vipId为Null
    int modifyVipIdBySellAccountId(String sellAccountId);

    //根据vipid批量查找账单记录
    Sellaccount getSellAccountByVipIds(Integer vipId);
    //批量修改账单的vipId
    int modifyVips(String sellAccountId);


}