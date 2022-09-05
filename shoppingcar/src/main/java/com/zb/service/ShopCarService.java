package com.zb.service;

import com.zb.pojo.ShopCar;

import java.util.List;

public interface ShopCarService {

    //查询数据库中的购物车列表
    List<ShopCar> listShopCar(String skuName);

    //逻辑删除
    Integer updateLogicState(Integer id);

}
