package com.skyhospital.service.drug.impl;

import com.skyhospital.dao.GoodsallocationMapper;
import com.skyhospital.pojo.Goodsallocation;
import com.skyhospital.service.drug.GoodsallocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名：skyhospital
 * 类名：GoodsallocationServiceImpl
 * 描述：货位-业务实现
 * 创建时间：2018.08.06 上午 11:44
 * 创建者: Amy
 */
@Service("GoodsallocationService")
public class GoodsallocationServiceImpl implements GoodsallocationService{
    @Autowired
    private GoodsallocationMapper goodsallocationMapper;

    @Override
    public List<Goodsallocation> findAllGAName() {
        return goodsallocationMapper.findAllGAName();
    }
}
