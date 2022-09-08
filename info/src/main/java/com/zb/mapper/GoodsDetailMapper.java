package com.zb.mapper;

import com.zb.pojo.Color;
import com.zb.pojo.Goodsku;
import com.zb.pojo.ImagesFk;
import com.zb.pojo.ShopCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface GoodsDetailMapper {

    Goodsku getGoodSkuByDetail(@Param("id") String id);
    List<ImagesFk> getImagesFk(@Param("id") String id);
    int getSpu(@Param("id") String id);
    List<Color> getColorList(@Param("id") int id);
    int getCountOfShoppingCar();
    int getColorId(@Param("colorName") String colorName);
    int getPriceId(@Param("price") BigDecimal price,@Param("skuid") String skuid);
    int addShoppingCar(@Param("shopCar") ShopCar shopCar);
    int getWareHouseid(@Param("skuId") String skuId);
}
