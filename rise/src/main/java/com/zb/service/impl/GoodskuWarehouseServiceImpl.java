package com.zb.service.impl;

import com.zb.mapper.GoodskuWarehouseMapper;
import com.zb.pojo.GoodskuWarehouse;
import com.zb.service.GoodskuWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodskuWarehouseServiceImpl implements GoodskuWarehouseService {

    @Autowired
    private GoodskuWarehouseMapper goodskuWarehouseMapper;

    @Override
    public List<GoodskuWarehouse> selectAll() {
        return goodskuWarehouseMapper.selectAll();
    }
}
