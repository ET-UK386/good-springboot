package com.zb.mapper;

import com.zb.pojo.InSellingGoods;
import com.zb.pojo.ProductRise;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductRiseMapper {
    /**
     * 添加上架表数据
     * @param productRise
     * @return
     */
    Integer add(ProductRise productRise);

    /**
     * 查询所有上架商品
     * @return
     */
    List<InSellingGoods> findInSellingGoodsAll();

}
