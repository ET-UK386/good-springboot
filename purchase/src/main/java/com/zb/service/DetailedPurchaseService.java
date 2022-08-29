package com.zb.service;

import com.zb.pojo.DetailedPurchase;
import com.zb.pojo.Vendor;

import java.util.List;

public interface DetailedPurchaseService {

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
    Integer modifyById(DetailedPurchase detailedPurchase);

    /**
     * 添加
     *
     * @return 搜影响行数
     */
    Integer addDetailedPurchaseAndPurchase(List<DetailedPurchase> List);

    /**
     * 查找所有经销商
     *
     * @return
     */
    List<Vendor> findVendor();

    /**
     * 该审核单内所有详细单审核通过
     *
     * @param purchaseId 审核单ID
     * @return 成功或失败
     */
    Integer examinationPassed(Long purchaseId);

    Integer deleteByPurchaseId(Long purchaseId);

    Integer bulkAdd(List<DetailedPurchase> list,Long purchaseId);
}
