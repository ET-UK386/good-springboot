package com.zb.service;

import com.zb.pojo.Price;
import com.zb.pojo.Purchase;

import java.util.List;

public interface PriceService {
    //查询
    List<Price> listPrice(Long sku_id);
}
