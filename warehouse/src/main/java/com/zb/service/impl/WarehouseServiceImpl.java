package com.zb.service.impl;

import com.zb.mapper.WarehouseMapper;
import com.zb.pojo.Warehouse;
import com.zb.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;


    @Override
    public List<Warehouse> findAll() {
        return warehouseMapper.selectAll();
    }

    @Override
    public Integer add(Warehouse warehouse) {
        return warehouseMapper.insert(warehouse);
    }

    @Override
    public List<Warehouse> findList() {
        return warehouseMapper.selectList();
    }

    @Override
    public List<Warehouse> findBySkuIdWarehouses(Long skuId) {
        return warehouseMapper.selectBySkuIdWarehouses(skuId);
    }
}
