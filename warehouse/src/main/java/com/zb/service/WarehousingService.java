package com.zb.service;

import com.zb.pojo.Purchase;
import com.zb.pojo.User;
import com.zb.pojo.Warehousing;

import java.util.List;

public interface WarehousingService {

    /** 查询所有*/
    List<Warehousing> findAll();

    /** 根据id查询*/
    Warehousing findById(Long id);

    /**
     * 入库前审核
     * @param warehousing 审核订单
     * @param loginUser 登录用户（审核人）
     * @return
     */
    Integer checkBeforeStorage(Warehousing warehousing, User loginUser);

    /**
     * 根据进货流程创建订单
     * @param purchase 进货订单
     * @return
     */
    Integer createWarehousing(Purchase purchase);
}
