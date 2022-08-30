package com.zb.service;

import com.zb.pojo.GoodskuWarehouse;

import java.util.List;

public interface GoodskuWarehouseService {

    /**
     * 查询所有商品的商品
     * @return
     */
    List<GoodskuWarehouse> selectAll();


}
