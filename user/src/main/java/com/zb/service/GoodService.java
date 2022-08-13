package com.zb.service;


import com.zb.pojo.Goodsku;

import java.util.List;

public interface GoodService {
    /**
     * 查询所有商品
     * @return
     */
    List<Goodsku> listGood();
}
