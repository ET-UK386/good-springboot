package com.zb.mapper;

import com.zb.pojo.ProductRise;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductRiseMapper {
    Integer add(ProductRise productRise);
}
