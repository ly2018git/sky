package com.skyhospital.service.drug;

import com.skyhospital.pojo.Goodsallocation;

import java.util.List;

/**
 * 项目名：skyhospital
 * 类名：GoodsallocationService
 * 描述：货位-业务层
 * 创建时间：2018.08.06 上午 11:44
 * 创建者: Amy
 */
public interface GoodsallocationService {
    //获取所有的货位名称
    List<Goodsallocation> findAllGAName();
}
