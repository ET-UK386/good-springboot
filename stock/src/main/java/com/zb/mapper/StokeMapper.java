package com.zb.mapper;

import com.zb.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface StokeMapper {
    List<Purchase> listPurchase();

    List<DetailedPurchase> listPurchaseDetailedPurchase();

    List<DetailedPurchase> listPurchaseDetailedPurchaseBylistPurchaseId(Long id);

    List<Goodsku> listGoodSku();

    Goodsku listGoodSkuById(Integer id);

    Integer addPurchase(Purchase p);

    Integer addDetailedPurchase(DetailedPurchase d);

    List<Vendor> listVendor();

    Price listPriceById(Integer id);

    Integer listMaxPurchaseId();


    /**
     * @param userId      修改用户
     * @param renewUserId 更新用户
     * @param id          订单id
     * @param status      审核状态
     * @param opinion     审核意见
     * @param exDate      审核时间
     * @param renDate     更新时间
     * @return
     */
    Integer updatePurchaseById(@Param("userId") long userId,
                               @Param("renewUserId") Long renewUserId,
                               @Param("id") long id,
                               @Param("status") Integer status,
                               @Param("opinion") String opinion,
                               @Param("exDate") Date exDate,
                               @Param("renDate") Date renDate);

    Integer updateDetailedPurchase(@Param("status") long status,
                                   @Param("renewId") long renewId,
                                   @Param("reTime") Date reTime,
                                   @Param("puId") long puId);
}
