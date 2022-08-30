package com.zb.service.impl;

import com.zb.mapper.PriceMapper;
import com.zb.mapper.ProductRiseMapper;
import com.zb.pojo.Price;
import com.zb.pojo.ProductRise;
import com.zb.pojo.front.Goodrise;
import com.zb.service.IGoodriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
@Service
@Transactional
public class GoodriseServiceImpl implements IGoodriseService {

    @Autowired
    private PriceMapper priceMapper;

    @Autowired
    private ProductRiseMapper productRiseMapper;


    @Override
    public boolean saveGoodrise(Goodrise goodrise) {

        if(Objects.isNull(goodrise.getSkuId()) || Objects.isNull(goodrise.getPrice())){
            return false;
        }

        Price p = new Price();
        p.setSkuId(goodrise.getSkuId());
        p.setPrice(goodrise.getPrice());
        Integer integer = priceMapper.addPrice(p);

        if(integer < 1){
            return false;
        }
        Long pid = p.getId();
        ProductRise productRise = new ProductRise();
        productRise.setPriceId(pid);
        productRise.setNumber(goodrise.getStockNumber());
        productRise.setSkuId(goodrise.getSkuId());
        productRise.setStatus(1);
        // TODO: 2022/8/30 token 没搞定 
        productRise.setUserId(1);

        Integer add = productRiseMapper.add(productRise);
        if(add < 1){
            return false;
        }

        return true;
    }
}
