package com.zb.service;

import com.zb.pojo.Price;

import java.util.List;

public interface PriceService {
    //查询
    List<Price> listPrice(Integer sku_id);
}
