package com.zb.service.impl;

import com.zb.mapper.DetailedPurchaseMapper;
import com.zb.mapper.PurchaseMapper;
import com.zb.pojo.DetailedPurchase;
import com.zb.pojo.Purchase;
import com.zb.pojo.Vendor;
import com.zb.service.DetailedPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class DetailedPurchaseServiceImpl implements DetailedPurchaseService {

    @Autowired
    private DetailedPurchaseMapper detailedPurchaseMapper;
    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public Integer modifyById(DetailedPurchase detailedPurchase) {
        return detailedPurchaseMapper.updateById(detailedPurchase);
    }

    @Override
    public Integer examinationPassed(Long purchaseId) {
        List<DetailedPurchase> list = this.selectByPurchaseId(purchaseId);
        for (DetailedPurchase d : list) {
            d.setStatus(1);
            Integer integer = this.modifyById(d);
            if (integer <= 0) {
                return -1;
            }
        }
        return 1;
    }


    @Override
    public Integer add(List<DetailedPurchase> list) {

        // 获取添加几件商品
        int size = list.size();
        // 封装数据
        Purchase p = new Purchase();
        p.setPurchaseNumber(size);
        p.setExamineStatus(0);
        // 先添加purchase 数据
        Integer insert = purchaseMapper.insert(p);

        if (insert > 0) {
            BigDecimal sum = new BigDecimal(0);
            // 循环添加详细订单的流程订单ID 并计算总价格
            for (DetailedPurchase detailedPurchase : list) {
                // 设置PurchaseId
                detailedPurchase.setPurchaseId(p.getId());
                // 获取进货数量
                BigDecimal num = new BigDecimal(detailedPurchase.getNumber());
                // 获取进价
                BigDecimal price = detailedPurchase.getPurchasePrice();
                // 计算总进货价
                sum = sum.add(price.multiply(num));
                // 添加详细订单
                Integer insert1 = detailedPurchaseMapper.insert(detailedPurchase);
                if (insert1 <= 0) {
                    return -1;
                }
            }
            p.setSumPrice(sum);
            // 修改进货单总价
            purchaseMapper.updateById(p);
        } else {
            return -1;
        }
        return 1;
    }

    @Override
    public List<Vendor> findVendor() {
        return detailedPurchaseMapper.selectVendor();
    }

    @Override
    public List<DetailedPurchase> selectByPurchaseId(Long purchaseId) {
        return detailedPurchaseMapper.selectByPurchaseId(purchaseId);
    }
}
