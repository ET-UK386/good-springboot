package com.zb.service;

import com.zb.pojo.*;

        import java.util.Date;
        import java.util.List;

public interface StokeServicec {
    List<Purchase> listPurchase();

    List<DetailedPurchase> listPurchaseDetailedPurchase();

    List<DetailedPurchase> listPurchaseDetailedPurchaseBylistPurchaseId(Long id);

    List<Goodsku> listGoodSku();

    Integer addPurchase(Purchase p);

    Integer addDetailedPurchase(DetailedPurchase d);

    List<Vendor> listVendor();

    Goodsku listGoodSkuById(Integer goods);

    Price listPriceById(Integer id);

    Integer listMaxPurchaseId();

    Integer updatePurchaseById(long userId, Long renewUserId, long id, Integer status, String opinion, Date exDate, Date renDate);

    Integer updateDetailedPurchase(long status,long renewId,Date reTime,long puId);
}
