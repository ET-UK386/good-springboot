package com.zb.controller;

import com.zb.pojo.Goodsku;
import com.zb.pojo.Goodspu;

import com.zb.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goodspu")
@CrossOrigin("*")
public class GoodController {

    @Autowired
    private GoodService goodService;

    @RequestMapping("/listGoodsku")
    public List<Goodsku> listGoodsku(){
        List<Goodsku> goodskus = goodService.listGood();
        System.out.println("=========");
        System.out.println("=========");
        System.out.println("=========");
        System.out.println(goodskus);
        return goodskus;
    }

}
