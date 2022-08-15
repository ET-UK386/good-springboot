package com.zb.controller;

import com.zb.pojo.Purchase;
import com.zb.pojo.User;
import com.zb.pojo.Warehousing;
import com.zb.service.WarehousingService;
import com.zb.utils.Result;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
                Map<String, Object> res = warehousingService.createWarehousing(purchase);
                String success = (String) res.get("success");
                String error = (String) res.get("error");
                if(Strings.isEmpty(error) && Strings.isNotEmpty(success)){
                    // 该进货流程全部创建完成
                    code = 200;
                    message = "成功创建：" +success + "创建失败："+error;
                }else if(Strings.isNotEmpty(success) && Strings.isNotEmpty(error)){
                    // 该进货流程有个别未完成
                    code = 404;
                    message = "成功创建：" +success + "创建失败："+error;
                }else{
                    // 全部都失败
                    code = 500;
                    message = "异常";
                }
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
     * 查询需要审核的入库流程列表
     * @return
     */
    @GetMapping("checkBeforeStorage")
    public Result checkBeforeStorage(){
        List<Warehousing> warehousings = warehousingService.findAuditWarehousing();
        return new Result().setCode(200).setMessage("success").setData(warehousings);
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

    /**
     * 查询需要入库审核的入库流程列表
     * @return
     */
    @GetMapping("checkBeforeStorage")
    public Result inventoryAudit(){
        List<Warehousing> warehousings = warehousingService.findInventoryAudit();
        return new Result().setCode(200).setMessage("success").setData(warehousings);
    }

    /**
     * 入库前审核（）
     */
    @PutMapping("inventoryAudit")
    public void inventoryAudit(@RequestBody Warehousing warehousing, String token) {
        // 获取当前登录用户
        User loginUser = (User) redisTemplate.opsForValue().get(token);
        warehousingService.inventoryAudit(warehousing, loginUser);
    }



}