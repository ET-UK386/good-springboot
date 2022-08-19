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
     * 根据skuid分组查询
     * @return
     */
    List<Warehouse> selectList();

    /**
     * 根据skuid查询列表
     * @param skuId
     * @return
     */
    List<Warehouse> selectBySkuIdWarehouses(Long skuId);


    /**
     * 添加
     * @param warehouse
     * @return
     */
    Integer insert(Warehouse warehouse);
}
