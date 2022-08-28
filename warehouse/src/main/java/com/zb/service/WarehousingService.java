package com.zb.service;

import com.zb.pojo.DetailedWarehousing;
import com.zb.pojo.Purchase;
import com.zb.pojo.User;
import com.zb.pojo.Warehousing;

import java.util.List;
import java.util.Map;

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

    /**
     * 入库审核
     * @param warehousing 审核订单
     * @param loginUser 登录用户（审核人）
     * @return
     */
    Integer inventoryAudit(Warehousing warehousing, User loginUser);

    /**
     * 查询审核状态的入库流程
     * @return
     */
    List<Warehousing> findAuditWarehousing();

    /**
     * 查询入库审核状态的入库流程
     * @return
     */
    List<Warehousing> findInventoryAudit();

    /**
     * 添加入库审核详细订单
     * @param detailedWarehousing
     * @return
     */
    Integer insertDetailedWarehousing(DetailedWarehousing detailedWarehousing);

    List<DetailedWarehousing> findDetailedWarehousingByWarehousingId(Long warehousingId);
}
