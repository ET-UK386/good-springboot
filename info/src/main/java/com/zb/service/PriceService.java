package com.zb.service;

import com.zb.pojo.Purchase;

import java.util.List;

public interface PriceService {
    //查询
    List<Purchase.Price> listPrice(Integer sku_id);
}
