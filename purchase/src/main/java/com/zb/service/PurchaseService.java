package com.zb.service;

import com.zb.pojo.DetailedPurchase;
import com.zb.pojo.Purchase;

import java.util.List;

public interface PurchaseService {
    /**
     * 查询全部
     *
     * @return Purchase
     */
    List<Purchase> findAll();

    /**
     * 查询未审核进货流程单
     * @return
     */
    List<Purchase> findPurchaseNotReviewed();

    /**
     * 查询已审核进货流程单
     * @return
     */
    List<Purchase> findPurchaseAudited();

    Integer audit(Purchase purchase);

    Integer modifyPurchase(Long purchaseId, List<DetailedPurchase> list);
}
