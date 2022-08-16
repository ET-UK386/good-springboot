package com.zb.controller;

import com.zb.pojo.Purchase;
import com.zb.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/price")
public class PriceController {
    @Autowired(required = false)
    private PriceService priceService;

    @RequestMapping("/listPrice")

    public List<Purchase.Price> listPrice(@RequestBody Purchase.Price price){
        return priceService.listPrice(price.getSkuId());
    }
}
