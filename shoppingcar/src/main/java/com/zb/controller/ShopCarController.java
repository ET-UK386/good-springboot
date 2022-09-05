package com.zb.controller;

import com.zb.pojo.Goodsku;
import com.zb.pojo.ShopCar;
import com.zb.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/shopcar")
public class ShopCarController {
    @Autowired(required = false)
    private ShopCarService shopCarService;

    //查询列表
    @RequestMapping("/listShopCar")
    public List<ShopCar> listShopCar(@RequestBody Goodsku goodsku){
        System.out.println("------------------");
        System.out.println(shopCarService.listShopCar(goodsku.getSkuName()));
        return shopCarService.listShopCar(goodsku.getSkuName());
    }

    //逻辑删除
    @RequestMapping("/deleteShopCar")
    public int updateLogicState(@RequestBody ArrayList<ShopCar> shopCar){
        System.out.println("修改");
        int flag = 0;
        for(ShopCar s : shopCar){
            System.out.println(s.getId());
            flag = shopCarService.updateLogicState(s.getId());
            System.out.println(flag);
        }

        return flag;
    }
}
