package com.zb.mapper;

import com.zb.pojo.ShopCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ShopCarMapper {
    //查询数据库中的购物车列表
    List<ShopCar> listShopCar(Map<String,Object> map);

    //逻辑删除
    int multiDelete(@Param("id") int id);
}
