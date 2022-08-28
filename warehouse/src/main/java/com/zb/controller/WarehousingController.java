package com.zb.controller;

import com.zb.pojo.DetailedWarehousing;
import com.zb.pojo.Purchase;
import com.zb.pojo.User;
import com.zb.pojo.Warehousing;
import com.zb.service.WarehousingService;
import com.zb.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("warehousing")
@CrossOrigin
public class WarehousingController {

    @Autowired
    private WarehousingService warehousingService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 查询列表
     *
     * @return
     */
    @GetMapping("findAll")
    public Result findAll() {

        List<Warehousing> list = warehousingService.findAll();
        return new Result().setCode(200).setData(list).setMessage("success");
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("find/{id}")
    public Result findById(@PathVariable("id") Long id) {
        Warehousing warehousing = warehousingService.findById(id);

        return new Result().setCode(200).setData(warehousing).setMessage("success");
    }

    /**
     * 创建入库订单
     */
    @PostMapping("createWarehousing")
    public Result createWarehousing(@RequestBody Purchase purchase) {
        // 获取流程审核状态
        Integer purchaseStatus = purchase.getExamineStatus();

        Integer warehousing = warehousingService.createWarehousing(purchase);

        if (warehousing == -1) {
            return new Result().setMessage("error").setCode(500);
        }

        return new Result().setMessage("success").setCode(200);
    }

    /**
     * 查询需要审核的入库流程列表
     *
     * @return
     */
    @GetMapping("checkBeforeStorage")
    public Result checkBeforeStorage() {
        List<Warehousing> warehousings = warehousingService.findAuditWarehousing();
        return new Result().setCode(200).setMessage("success").setData(warehousings);
    }

    /**
     * 入库前审核（）
     */
    @PutMapping("checkBeforeStorage")
    public Result checkBeforeStorage(@RequestBody Warehousing warehousing) {

        String token = warehousing.getToken();
        // 获取当前登录用户
        User loginUser = (User) redisTemplate.opsForValue().get(token);
        warehousingService.checkBeforeStorage(warehousing, loginUser);
        return new Result().setMessage("success").setCode(200);
    }

    /**
     * 查询需要入库审核的入库流程列表
     *
     * @return
     */
    @GetMapping("inventoryAudit")
    public Result inventoryAudit() {
        List<Warehousing> warehousings = warehousingService.findInventoryAudit();
        return new Result().setCode(200).setMessage("success").setData(warehousings);
    }

    /**
     * 入库前审核（）
     */
    @PutMapping("inventoryAudit")
    public Result inventoryAudit(@RequestBody Warehousing warehousing) {


        String token = warehousing.getToken();
        // 获取当前登录用户
        User loginUser = (User) redisTemplate.opsForValue().get(token);
        Integer integer = warehousingService.inventoryAudit(warehousing, loginUser);

        return new Result().setCode(200).setMessage("success");
    }

    /**
     * 获取入库详细单
     *
     * @param warehousingId
     * @return
     */
    @GetMapping("getDetailedWarehousingByWarehousingId/{id}")
    public Result getDetailedWarehousingByWarehousingId(@PathVariable("id") Long warehousingId) {
        List<DetailedWarehousing> list = warehousingService.findDetailedWarehousingByWarehousingId(warehousingId);
        return new Result().setCode(200).setMessage("success").setData(list);
    }


}