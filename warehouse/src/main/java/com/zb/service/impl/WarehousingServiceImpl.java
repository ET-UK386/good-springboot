package com.zb.service.impl;

import com.zb.mapper.WarehousingMapper;
import com.zb.pojo.DetailedPurchase;
import com.zb.pojo.Purchase;
import com.zb.pojo.User;
import com.zb.pojo.Warehousing;
import com.zb.service.DetailedPurchaseService;
import com.zb.service.WarehousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class WarehousingServiceImpl implements WarehousingService {

    @Autowired
    private WarehousingMapper warehousingMapper;
    @Autowired
    private DetailedPurchaseService detailedPurchaseService;

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
    public Integer createWarehousing(Purchase purchase) {
        // 根据进货单id获取所有的进货详细单
        List<DetailedPurchase> detailedPurchases = detailedPurchaseService.selectByPurchaseId(purchase.getId());
        for (DetailedPurchase detailedPurchase : detailedPurchases) {
            // TODO: 2022/8/14 根据进货流程创建订单未完成
        }
        return null;
    }
}
