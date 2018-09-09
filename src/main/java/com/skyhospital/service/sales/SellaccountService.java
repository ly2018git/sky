package com.skyhospital.service.sales;

import com.skyhospital.pojo.Sellaccount;
import com.skyhospital.tools.PageUtil;

import java.util.Map;

/**
 * 项目名：skyhospital
 * 类名：SellaccountService
 * 描述：销售账单-业务层
 * 创建时间：2018.08.06 上午 11:54
 * 创建者: Amy
 */
public interface SellaccountService {
    //添加销售药品
    int addSellCount(Sellaccount sellaccount);
    //int addSellCount(String sd20180120, int i, Date date, String vips1111, BigDecimal amount, BigDecimal actuallyPaid, BigDecimal due, BigDecimal cutAmount, String 是会员, String 微信支付, String 售出药品, Date jiezhang, String 小明, int i1);
    //销售营业额分页查询Integer UID,Integer pageIndex,Integer pageSize
    PageUtil findSaleTurnover(Map<String, Object> map)throws Exception;
}
