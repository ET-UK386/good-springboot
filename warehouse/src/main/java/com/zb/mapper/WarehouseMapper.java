package com.zb.mapper;

import com.zb.pojo.Warehouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WarehouseMapper {

    /**
     * 查询全部
     * @return
     */
    List<Warehouse> selectAll();

    /**
     * 添加
     * @param warehouse
     * @return
     */
    Integer insert(Warehouse warehouse);
}
