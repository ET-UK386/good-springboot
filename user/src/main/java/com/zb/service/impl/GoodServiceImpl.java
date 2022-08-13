package com.zb.service.impl;


import com.zb.mapper.GoodMapper;
import com.zb.pojo.Goodsku;

import com.zb.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
@Transactional
public class GoodServiceImpl implements GoodService {
    /**
     * 查询所有商品
     *
     * @return
     */

    @Autowired(required = false)
    private GoodMapper goodMapper;

    @Override
    public List<Goodsku> listGood() {
        return goodMapper.listGood();
    }
}
