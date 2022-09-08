package com.zb.service.impl;

import com.zb.mapper.GoodsDetailMapper;
import com.zb.pojo.Color;
import com.zb.pojo.Goodsku;
import com.zb.pojo.ImagesFk;
import com.zb.pojo.ShopCar;
import com.zb.service.GoodsDetailService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class GoodsDetailServiceImpl implements GoodsDetailService {

    @Autowired
    private GoodsDetailMapper goodsDetailMapper;

    @Override
    public Goodsku getGoodSkuByDetail(String id) {
        return goodsDetailMapper.getGoodSkuByDetail(id);
    }

    @Override
    public List<ImagesFk> getImagesFk(String id) {
        return goodsDetailMapper.getImagesFk(id);
    }

    @Override
    public int getSpu(@Param("id") String id) {
        return goodsDetailMapper.getSpu(id);
    }

    @Override
    public List<Color> getColorList(int id) {
        return goodsDetailMapper.getColorList(id);
    }

    @Override
    public int getCountOfShoppingCar() {
        return goodsDetailMapper.getCountOfShoppingCar();
    }

    @Override
    public int getColorId(String colorName) {
        return goodsDetailMapper.getColorId(colorName);
    }

    @Override
    public int getPriceId(BigDecimal price, String skuid) {
        return goodsDetailMapper.getPriceId(price,skuid);
    }


    @Override
    public int addShoppingCar(ShopCar shopCar) {
        return goodsDetailMapper.addShoppingCar(shopCar);
    }

    @Override
    public int getWareHouseid(String skuId) {
        System.out.println(skuId);
        return goodsDetailMapper.getWareHouseid(skuId);
    }
}
