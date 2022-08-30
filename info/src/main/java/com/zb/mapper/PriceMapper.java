package com.zb.mapper;

import com.zb.pojo.Price;
import com.zb.pojo.Purchase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface PriceMapper {
    //查询
    List<Price> listPrice(Long sku_id);

    Integer addPrice(Price p);
}
