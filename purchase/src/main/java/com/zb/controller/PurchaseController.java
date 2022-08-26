package com.zb.controller;

import com.zb.pojo.*;
import com.zb.service.DetailedPurchaseService;
import com.zb.service.GoodService;
import com.zb.service.PurchaseService;
import com.zb.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("/purchase")
@RestController
@CrossOrigin
public class PurchaseController {

    @Autowired
    private DetailedPurchaseService detailedPurchaseService;
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private GoodService goodService;


    /**
     * 批量添加 DetailedPurchase
     *
     * @param list DetailedPurchase集合
     */
    @PostMapping("addPurchase")
    public Result addPurchase(@RequestBody List<DetailedPurchase> list) {
        // 数据验证
        if (list.size() == 0) {
            return new Result().setCode(404).setMessage("请添加数据");
        }
        for (DetailedPurchase detailedPurchase : list) {
            if (detailedPurchase.getNumber() <= 0) {
                return new Result().setCode(404).setMessage("进货数量不合法");
            }
            if (detailedPurchase.getPurchasePrice().compareTo(new BigDecimal(0)) <= 0) {
                return new Result().setCode(404).setMessage("进货价格不合法");
            }
        }
        // 添加数据
        Integer add = detailedPurchaseService.add(list);

        if (add == -1) {
            return new Result().setCode(500).setMessage("添加失败");
        }

        System.out.println(list);
        return new Result().setCode(200).setMessage("添加成功");
    }

    /**
     * 查找所有goodsku
     *
     * @return
     */
    @GetMapping("getGookSku")
    public Result getgoodSku() {
        List<Goodsku> allGoodsku = goodService.findAllGoodsku();
        return new Result().setData(allGoodsku);
    }

    /**
     * 查找所有Vendor
     *
     * @return
     */
    @GetMapping("getVendor")
    public Result getVendor() {
        List<Vendor> vendor = detailedPurchaseService.findVendor();
        return new Result().setData(vendor);
    }

    /**
     * 查询所有进货流程表
     *
     * @return
     */
    @GetMapping("getPurchase")
    public Result getPurchase() {
        List<Purchase> all = purchaseService.findAll();
        return new Result().setCode(200).setMessage("success").setData(all);
    }

    /**
     * 根据purchaseId 查询所属 详细订单
     *
     * @param purchaseId
     * @return
     */
    @GetMapping("getDetailedPurchaseByPurchaseId/{id}")
    public Result getDetailedPurchaseByPurchaseId(@PathVariable("id") Long purchaseId) {
        List<DetailedPurchase> detailedPurchases = detailedPurchaseService.selectByPurchaseId(purchaseId);
        return new Result().setData(detailedPurchases).setCode(200).setMessage("success");
    }

    /**
     * 审核Purchase流程
     *
     * @return
     */
    @PutMapping("purchaseAudit")
    public Result purchaseAudit(@RequestBody Purchase purchase) {

        if(!(purchase.getExamineStatus() == 1 || purchase.getExamineStatus() == 2)){
            return new Result().setMessage("流程状态不对，请确认").setCode(404);
        }

        // 调用service实现审核
        Integer audit = purchaseService.audit(purchase);
        if (audit == -1) {
            return new Result().setMessage("error").setCode(500);
        }else if(audit == 0){
            return new Result().setCode(404).setMessage("success,审核不通过").setData(purchase);
        }
        return new Result().setCode(200).setMessage("success，审核通过").setData(purchase);
    }

}
