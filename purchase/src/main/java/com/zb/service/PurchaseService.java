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
}
