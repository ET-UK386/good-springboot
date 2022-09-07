package com.zb.controller;

import com.zb.pojo.Goodsku;
import com.zb.service.GoodsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin("*")
@RequestMapping("goodsdetail")
public class SkuController {

    @Autowired
    private GoodsDetailService goodsDetailService;

    @RequestMapping("showdetail")
    @ResponseBody
    public Goodsku showdetail(String skuid){
        System.out.println("1111111");
        return goodsDetailService.getGoodSkuByDetail(skuid);
    }

}
