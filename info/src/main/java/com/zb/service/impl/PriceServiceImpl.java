package com.zb.service.impl;

import com.zb.mapper.PriceMapper;
import com.zb.pojo.Price;
import com.zb.pojo.Purchase;
import com.zb.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PriceServiceImpl implements PriceService {
    @Autowired(required = false)
    private PriceMapper priceMapper;
    @Override
    public List<Price> listPrice(Long sku_id) {
        return priceMapper.listPrice(sku_id);
    }
}
