package com.zb.service;

import com.zb.pojo.DetailedPurchase;
import com.zb.pojo.Purchase;

import java.util.List;

public interface StokeServicec {
    List<Purchase> listPurchase();

    List<DetailedPurchase> listPurchaseDetailedPurchase();

    List<DetailedPurchase> listPurchaseDetailedPurchaseBylistPurchaseId(Integer id);
}
