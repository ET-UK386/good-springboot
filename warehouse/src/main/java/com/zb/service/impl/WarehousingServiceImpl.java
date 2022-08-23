package com.zb.service.impl;

import com.zb.mapper.WarehousingMapper;
import com.zb.pojo.*;
import com.zb.service.StokeServicec;
import com.zb.service.WarehouseService;
import com.zb.service.WarehousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class WarehousingServiceImpl implements WarehousingService {

    @Autowired
    private WarehousingMapper warehousingMapper;
    @Autowired
    private StokeServicec stokeServicec;
    @Autowired
    private WarehouseService warehouseService;

    /**
     * 查询全部
     *
     * @return
     */
    @Override
    public List<Warehousing> findAll() {
        return warehousingMapper.selectAll();
    }

    /**
     * 入库前审核
     *
     * @param warehousing 审核订单
     * @param loginUser   登录用户（审核人）
     * @return
     */
    @Override
    public Integer checkBeforeStorage(Warehousing warehousing, User loginUser) {
        warehousing.setExamineUserId(loginUser.getId());
        warehousing.setExamineTime(new Date(System.currentTimeMillis()));
        return warehousingMapper.checkBeforeStorage(warehousing);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public Warehousing findById(Long id) {
        return warehousingMapper.selectById(id);
    }

    /**
     * 创建入库流程单
     *
     * @param purchase 进货订单
     * @return
     */
    @Override
    public Map<String, StringBuilder> createWarehousing(Purchase purchase) {
        Warehousing warehousing = new Warehousing();
        // 根据进货单id获取所有的进货详细单
        List<DetailedPurchase> detailedPurchases = stokeServicec.listPurchaseDetailedPurchaseBylistPurchaseId(purchase.getId());

        StringBuilder successBatchs = new StringBuilder();
        StringBuilder errorBatchs = new StringBuilder();

        for (DetailedPurchase detailedPurchase : detailedPurchases) {
            if (detailedPurchase.getStatus() == 1) {
                if(detailedPurchase.getNumber() <= 0){
                    errorBatchs.append(detailedPurchase.getBatch() + "批次,创建失败， 详细订单进货数量不合法");
                }
                warehousing.setPurchaseId(purchase.getId())
                        .setDetailedPurchaseId(detailedPurchase.getId())
                        .setWarehousingNumber(detailedPurchase.getNumber())
                        .setStatus(0)
                        .setCreateTime(new Date(System.currentTimeMillis()));
                Integer res = warehousingMapper.insert(warehousing);
                if (res > 0) {
                    successBatchs.append(detailedPurchase.getBatch()).append(",");
                } else {
                    errorBatchs.append(detailedPurchase.getBatch()).append(",");
                }
            }
        }
        Map<String, StringBuilder> map = new HashMap<>();
        map.put("success", successBatchs);
        map.put("error", errorBatchs);
        return map;
    }

    /**
     * 入库审核
     *
     * @param warehousing 审核订单
     * @param loginUser   登录用户（审核人）
     * @return
     */
    @Override
    public Integer inventoryAudit(Warehousing warehousing, User loginUser) {
        warehousing.setWarehousingUserId(loginUser.getId());
        warehousing.setWarehousingTime(new Date(System.currentTimeMillis()));

        // 入库审核
        Integer insert = warehousingMapper.checkBeforeStorage(warehousing);

        // 返回结果
        Integer res = null;
        if (insert > 0) {
            // 审核通过
            // 封装仓库实体类
            Warehouse w = new Warehouse();
            w.setCreateUserId(loginUser.getId());
            w.setCreateTime(new Date(System.currentTimeMillis()));
            w.setPhone(loginUser.getPhone());
            w.setDetailedPurchaseId(warehousing.getDetailedPurchaseId());
            w.setStockNumber(warehousing.getWarehousingNumber());
            w.setWarehouseAddress("1号仓库");
            w.setSkuId(warehousing.getDetailedPurchase().getSkuId());
            // 添加仓库数据
            Integer add = warehouseService.add(w);

            if (add > 0) {
                // 仓库数据创建成功
                res = 1;
            } else{
                // 仓库数据创建失败
                res = 0;
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }else{
            // 入库流程审核不通过
            res = -1;
        }
        return res;
    }

    /**
     * 查询入库前审核列表
     *
     * @return
     */
    @Override
    public List<Warehousing> findAuditWarehousing() {
        // 审核状态
        Integer[] status = {0};
        return warehousingMapper.selectByStatus(status);
    }

    /**
     * 查询入库审核列表
     *
     * @return
     */
    @Override
    public List<Warehousing> findInventoryAudit() {
        // 审核状态
        Integer[] status = {2, 3};
        return warehousingMapper.selectByStatus(status);
    }
}
