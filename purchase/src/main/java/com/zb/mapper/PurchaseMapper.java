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
     * 根据状态查询
     * @param status 状态
     * @return 实体类集合
     */
    List<Purchase> selectByExamineStatus(Integer status);

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

    /**
     * 单纯根据id修改状态
     * @param purchaseId
     * @return
     */
    Integer updateStatusById(Long purchaseId);
}
