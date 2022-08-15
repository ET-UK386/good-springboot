package com.zb.service.impl;

import com.zb.mapper.WarehousingMapper;
import com.zb.pojo.DetailedPurchase;
import com.zb.pojo.Purchase;
import com.zb.pojo.User;
import com.zb.pojo.Warehousing;
import com.zb.service.StokeServicec;
import com.zb.service.WarehousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public List<Warehousing> findAll() {
        return warehousingMapper.selectAll();
    }

    @Override
    public Integer checkBeforeStorage(Warehousing warehousing, User loginUser) {
        warehousing.setExamineUserId(loginUser.getId());
        warehousing.setExamineTime(new Date(System.currentTimeMillis()));
        return warehousingMapper.checkBeforeStorage(warehousing);
    }

    @Override
    public Warehousing findById(Long id) {
        return warehousingMapper.selectById(id);
    }

    @Override
    public Map<String, Object> createWarehousing(Purchase purchase) {
        Warehousing warehousing = new Warehousing();
        // 根据进货单id获取所有的进货详细单
        List<DetailedPurchase> detailedPurchases = stokeServicec.listPurchaseDetailedPurchaseBylistPurchaseId(purchase.getId());
        StringBuilder successBatchs = new StringBuilder();
        StringBuilder errorBatchs = new StringBuilder();
        for (DetailedPurchase detailedPurchase : detailedPurchases) {
            // TODO: 2022/8/14 根据进货流程创建订单未完成
            if (detailedPurchase.getStatus() == 4) {
                warehousing.setPurchaseId(purchase.getId())
                        .setDetailedPurchaseId(detailedPurchase.getId())
                        .setWarehousingNumber(detailedPurchase.getNumber())
                        .setStatus(0)
                        .setCreateTime(new Date(System.currentTimeMillis()));
                Integer res = warehousingMapper.insert(warehousing);
                if (res > 0) {
                    successBatchs.append(detailedPurchase.getBatch()).append(",");
                }else{
                    errorBatchs.append(detailedPurchase.getBatch()).append(",");
                }
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("success", successBatchs);
        map.put("error", errorBatchs);
        return map;
    }

    @Override
    public Integer inventoryAudit(Warehousing warehousing, User loginUser) {
        warehousing.setWarehousingUserId(loginUser.getId());
        warehousing.setWarehousingTime(new Date(System.currentTimeMillis()));
        return warehousingMapper.checkBeforeStorage(warehousing);
    }

    @Override
    public List<Warehousing> findAuditWarehousing() {
        // 审核状态
        Integer status = 0;
        return warehousingMapper.selectByStatus(status);
    }

    @Override
    public List<Warehousing> findInventoryAudit() {
        // 审核状态
        Integer status = 3;
        return warehousingMapper.selectByStatus(status);
    }
}
