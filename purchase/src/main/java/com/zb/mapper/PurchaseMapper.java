package com.zb.mapper;

import com.zb.pojo.Purchase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurchaseMapper {

    /**
     * 查询全部
     *
     * @return Purchase
     */
    List<Purchase> selectAll();

    /**
     * 根据id查询
     *
     * @param id id
     * @return Purchase
     */
    Purchase selectById(Long id);

    /**
     * 根据id修改Purchase
     * @return 受影响行数
     */
    Integer updateById(Purchase purchase);

    /**
     * 添加
     *
     * @param purchase 实体类
     * @return 受影响行数
     */
    Integer insert(Purchase purchase);
}
