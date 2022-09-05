package com.zb.service.impl;

import com.zb.mapper.ShopCarMapper;
import com.zb.pojo.ShopCar;
import com.zb.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ShopCarServiceImpl implements ShopCarService {

    @Autowired(required = false)
    private ShopCarMapper shopCarMapper;

    @Override
    public List<ShopCar> listShopCar(String skuName) {
        Map<String,Object> map = new HashMap<>();
        if(skuName !=null && !skuName.equals("")){
            map.put("skuName",skuName);
        }
        return shopCarMapper.listShopCar(map);
    }

    @Override
    public Integer updateLogicState(Integer id) {

        return shopCarMapper.multiDelete(id);
    }

}
