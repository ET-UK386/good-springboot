package com.zb.service;

import com.zb.pojo.Color;
import com.zb.pojo.Goodsku;
import com.zb.pojo.ImagesFk;
import com.zb.pojo.ShopCar;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface GoodsDetailService {
    Goodsku getGoodSkuByDetail(String id);

    List<ImagesFk> getImagesFk(@Param("id") String id);

    int getSpu(@Param("id") String id);

    List<Color> getColorList(int id);

    int getCountOfShoppingCar();

    int getColorId( String colorName);

    int getPriceId(BigDecimal price,@Param("skuid") String skuid);

    int addShoppingCar(ShopCar shopCar);

    int getWareHouseid( String skuId);






}
