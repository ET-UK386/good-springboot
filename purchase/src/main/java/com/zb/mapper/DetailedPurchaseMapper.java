package com.zb.mapper;

import com.zb.pojo.DetailedPurchase;
import com.zb.pojo.Vendor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 1541
 */
@Mapper
public interface DetailedPurchaseMapper {


    /**
     * 根据id查询
     *
     * @param id id
     * @return 实体类
     */
    DetailedPurchase selectById(Long id);

    /**
     * 根据purchaseId查询
     *
     * @param purchaseId id
     * @return 实体类
     */
    List<DetailedPurchase> selectByPurchaseId(Long purchaseId);

    /**
     * 根据id修改
     *
     * @param id id
     * @return 搜影响行数
     */
    Integer updateById(DetailedPurchase detailedPurchase);

    /**
     * 添加
     *
     * @param detailedPurchase 实体类
     * @return 搜影响行数
     */
    Integer insert(DetailedPurchase detailedPurchase);

    /**
     * 查找所有经销商
     *
     * @return
     */
    List<Vendor> selectVendor();

}
