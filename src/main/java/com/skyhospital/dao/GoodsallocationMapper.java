package com.skyhospital.dao;

import com.skyhospital.pojo.Goodsallocation;

import java.util.List;

public interface GoodsallocationMapper {
    //获取所有的货位名称
    List<Goodsallocation> findAllGAName();
}