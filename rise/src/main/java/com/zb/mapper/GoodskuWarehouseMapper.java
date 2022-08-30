package com.zb.mapper;

import com.zb.pojo.GoodskuWarehouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodskuWarehouseMapper {

    List<GoodskuWarehouse> selectAll();


}
