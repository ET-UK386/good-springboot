package com.zb.service.impl;

import com.zb.mapper.GoodsDetailMapper;
import com.zb.pojo.Goodsku;
import com.zb.service.GoodsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoodsDetailServiceImpl implements GoodsDetailService {

    @Autowired
    private GoodsDetailMapper goodsDetailMapper;

    @Override
    public Goodsku getGoodSkuByDetail(String id) {
        return goodsDetailMapper.getGoodSkuByDetail(id);
    }
}
