package com.zb.service.impl;

import com.zb.mapper.PurchaseMapper;
import com.zb.pojo.Purchase;
import com.zb.pojo.User;
import com.zb.service.DetailedPurchaseService;
import com.zb.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseMapper purchaseMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public List<Purchase> selectAllPurchase() {
        return purchaseMapper.selectAllPurchase();
    }

    @Autowired
    private DetailedPurchaseService detailedPurchaseService;

    @Override
    public List<Purchase> findAll() {
        return purchaseMapper.selectAll();
    }

    @Override
    public Integer audit(Purchase purchase) {
        // 获取登录用户
        String token = purchase.getToken();
        User loginUser = (User) redisTemplate.opsForValue().get(token);
        // 当前时间
        Date currentTiem = new Date(System.currentTimeMillis());

        // 封装数据
        purchase.setExamineUserId(loginUser.getId());
        purchase.setExamineTime(currentTiem);


        Integer integer = purchaseMapper.updateById(purchase);
        if (purchase.getExamineStatus() == 1 && integer > 0) {
            Integer integer1 = detailedPurchaseService.examinationPassed(purchase.getId());
            if (integer1 <= 0) {
                return -1;
            }
        } else if (integer <= 0) {
            return -1;
        } else if (purchase.getExamineStatus() == 2) {
            return 0;
        }

        return 1;
    }
}
