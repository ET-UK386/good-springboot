package com.zb.controller;

import com.zb.pojo.*;
import com.zb.service.GoodsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("goodsdetail")
public class SkuController {

    @Autowired
    private GoodsDetailService goodsDetailService;

    /**
     * 商品详情页查看所选商品的sku
     * @param skuid
     * @return
     */
    @RequestMapping("showdetail/{skuid}")
    @ResponseBody
    public Goodsku showdetail(@PathVariable("skuid") String skuid){
        return goodsDetailService.getGoodSkuByDetail(skuid);
    }

    @RequestMapping("showImages/{skuid}")
    @ResponseBody
    public List<ImagesFk> showImages(@PathVariable("skuid") String skuid){
        return goodsDetailService.getImagesFk(skuid);
    }

    @RequestMapping("showColor/{skuid}")
    @ResponseBody
    public List<Color> showColor(@PathVariable("skuid") String skuid){
        int spuid = goodsDetailService.getSpu(skuid);
        List<Color> colorList = goodsDetailService.getColorList(spuid);
        return colorList;
    }

    /**
     * 获取购物车中商品数量
     * @return
     */
    @RequestMapping("countShoppingCar")
    @ResponseBody
    public int countShoppingCar(){
        return goodsDetailService.getCountOfShoppingCar();
    }


    /**
     * 添加到购物车表
     * @param
     */
    @RequestMapping("addToShoppingCar")
    @ResponseBody
    public int addToShoppingCar(@RequestBody HashMap<String,String> good){

        ShopCar s = new ShopCar();
        Long skuid = Long.parseLong(good.get("skuid"));
        s.setSkuId(skuid);
        String colorName = good.get("color");
        int colorId = goodsDetailService.getColorId(colorName);
        Color c = new Color();
        c.setColorName(colorName);
        c.setId(Long.parseLong(String.valueOf(colorId)));
        s.setColor(c);
        Long number = Long.parseLong(good.get("number"));
        s.setNumber(number);
        BigDecimal price = new BigDecimal(good.get("price"));
        int priceid = goodsDetailService.getPriceId(price,good.get("skuid"));
        Price p = new Price();
        p.setId(Long.parseLong(String.valueOf(priceid)));
        p.setPrice(price);
        s.setPrice(p);
        s.setLogicState(Long.parseLong("0"));
        int spuId = goodsDetailService.getSpu(good.get("skuid"));
        s.setSpuId(Long.parseLong(String.valueOf(spuId)));
        BigDecimal num = new BigDecimal(good.get("number"));
        s.setTotalPrice(price.multiply(num));
        int wareHouseId = goodsDetailService.getWareHouseid(good.get("skuid"));
        s.setWarehouseId(Long.parseLong(String.valueOf(wareHouseId)));
        int flag = goodsDetailService.addShoppingCar(s);

        return flag;

    }




}
