package com.zb.service;

import com.zb.pojo.InSellingGoods;
import com.zb.pojo.front.Goodrise;

import java.util.List;

public interface IGoodriseService {

    public boolean saveGoodrise(Goodrise goodrise);


    /**
     * 查询所有上架商品
     * @return
     */
    List<InSellingGoods> findInSellingGoodsAll();


}
