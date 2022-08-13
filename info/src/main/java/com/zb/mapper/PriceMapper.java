package com.zb.mapper;

import com.zb.pojo.Price;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PriceMapper {
    //查询
    List<Price> listPrice(Integer sku_id);
}
