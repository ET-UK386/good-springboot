package com.zb.mapper;

import com.zb.pojo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StokeMapper {
    List<Purchase> listPurchase();

    List<DetailedPurchase> listPurchaseDetailedPurchase();

    List<DetailedPurchase> listPurchaseDetailedPurchaseBylistPurchaseId(Long id);

    List<Goodsku> listGoodSku();

    Goodsku listGoodSkuById(Integer id);

    Integer addPurchase(Purchase p);

    Integer addDetailedPurchase(DetailedPurchase d);

    List<Vendor> listVendor();

    Price listPriceById(Integer id);
}
