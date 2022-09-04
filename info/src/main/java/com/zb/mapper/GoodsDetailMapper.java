package com.zb.mapper;

import com.zb.pojo.Goodsku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GoodsDetailMapper {

    Goodsku getGoodSkuByDetail(@Param("id") String id);

}
