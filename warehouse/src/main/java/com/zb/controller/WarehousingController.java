package com.zb.controller;

import com.zb.pojo.Purchase;
import com.zb.pojo.User;
import com.zb.pojo.Warehousing;
import com.zb.service.WarehousingService;
import com.zb.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

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
    public Result createWarehousing(Purchase purchase, String token) {
        // 获取流程审核状态
        Integer purchaseStatus = purchase.getStatus();
        // 获取当前登录用户
        User loginUser = (User) redisTemplate.opsForValue().get(token);

        Object data = null;
        String message = null;
        Integer code = null;
        switch (purchaseStatus) {
            case 0:
                message = "订单还未审核，不能创建入库订单";
                code = 500;
                break;
            case 1:
                Integer res = warehousingService.createWarehousing(purchase);
                break;
            case 2:
                message = "订单还未审核通过，不能创建入库订单";
                code = 500;
                break;
            case 3:
                message = "订单正在修改中，不能创建入库订单";
                code = 500;
                break;

            default:
                break;
        }

        return new Result(message, data, code);
    }

    /**
     * 入库前审核（）
     */
    @PutMapping("checkBeforeStorage")
    public void checkBeforeStorage(@RequestBody Warehousing warehousing, String token) {
        // 获取当前登录用户
        User loginUser = (User) redisTemplate.opsForValue().get(token);
        warehousingService.checkBeforeStorage(warehousing, loginUser);
    }
}