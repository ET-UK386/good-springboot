package com.zb.service;

import com.zb.pojo.Warehouse;

import java.util.List;

public interface WarehouseService {

    /**
     * 查询全部
     * @return
     */
    List<Warehouse> findAll();

    /**
     * 添加入库
     * @param warehouse
     * @return
     */
    Integer add(Warehouse warehouse);

    List<Warehouse> findList();


    /**
     * 根据skuid查询列表
     * @param skuId
     * @return
     */
    List<Warehouse> findBySkuIdWarehouses(Long skuId);
}
