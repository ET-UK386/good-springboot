package com.zb.controller;

import com.zb.pojo.GoodskuWarehouse;
import com.zb.pojo.InSellingGoods;
import com.zb.pojo.front.Goodrise;
import com.zb.service.GoodskuWarehouseService;
import com.zb.service.IGoodriseService;
import com.zb.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("gwc")
public class GoodRiseController {
    @Autowired
    private GoodskuWarehouseService goodskuWarehouseService;
    @Autowired
    private IGoodriseService goodriseService;

    @GetMapping("findAll")
    public Result findAll() {
        List<GoodskuWarehouse> goodskuWarehouses = goodskuWarehouseService.selectAll();
        return new Result().setCode(200).setMessage("success").setData(goodskuWarehouses);
    }

    @PostMapping("insertGood")
    public Result insertGood(@RequestBody Goodrise goodrise) {

        boolean b = goodriseService.saveGoodrise(goodrise);

        if (!b) {
            return new Result().setCode(500).setMessage("error");
        }

        return new Result().setCode(200).setMessage("success");
    }

    @GetMapping("findInSellingGoodsAll")
    public Result findInSellingGoodsAll() {
        List<InSellingGoods> inSellingGoodsAll = goodriseService.findInSellingGoodsAll();
        return new Result().setMessage("success").setCode(200).setData(inSellingGoodsAll);
    }

}
