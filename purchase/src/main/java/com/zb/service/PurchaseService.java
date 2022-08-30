package com.zb.service;

import com.zb.pojo.Purchase;

import java.util.List;

public interface PurchaseService {
    /**
     * 查询全部
     *
     * @return Purchase
     */
    List<Purchase> findAll();

    Integer audit(Purchase purchase);

    /**
     * 查询所有内容，包括审核过的和未审核的
     *
     * @return
     */
    List<Purchase> selectAllPurchase();
}
