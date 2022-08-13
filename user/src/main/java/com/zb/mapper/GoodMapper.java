package com.zb.mapper;

import com.zb.pojo.Goodsku;
import com.zb.pojo.Goodspu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodMapper {
    /**
     * 查询所有商品
     * @return
     */
    List<Goodsku> listGood();

}
