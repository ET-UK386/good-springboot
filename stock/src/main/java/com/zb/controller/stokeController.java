package com.zb.controller;

import com.zb.pojo.*;
import com.zb.service.StokeServicec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin("*")
public class stokeController {

    @Autowired(required = false)
    private StokeServicec stokeServicec;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("showAllStoke")
    @ResponseBody
    public List<Purchase> showAllStoke() {
        return stokeServicec.listPurchase();
    }

    @RequestMapping("listPurchaseDetailedPurchase")
    @ResponseBody
    public List<DetailedPurchase> listPurchaseDetailedPurchase() {
        return stokeServicec.listPurchaseDetailedPurchase();
    }

    @RequestMapping("listPurchaseDetailedPurchaseById/{id}")
    @ResponseBody
    public List<DetailedPurchase> listPurchaseDetailedPurchaseById(@PathVariable("id") Long id) {
        return stokeServicec.listPurchaseDetailedPurchaseBylistPurchaseId(id);
    }

    @RequestMapping("listGoodSku")
    @ResponseBody
    public List<Goodsku> listGoodSkuName() {
        return stokeServicec.listGoodSku();
    }


    /**
     * 采购商品
     *
     * @param token  令牌
     * @param Desc   进货说明
     * @param number 商品数量
     * @param goods  skuId
     * @param vendor 供应商Id
     * @return
     */
    @RequestMapping("addDetailedPurchase")
    @ResponseBody
    public Integer addDetailedPurchase(String token,
                                       String Desc,
                                       String number,
                                       String goods,
                                       String vendor) {
//        System.out.println("token:" + token);
//        System.out.println("Desc:" + Desc);
//        System.out.println("number:" + number);
//        System.out.println("goods:" + goods);
//        System.out.println("vendor:" + vendor);

        //获得更改用户的信息
        User o = (User) redisTemplate.opsForValue().get(token);
        /**设置详情表*/
        DetailedPurchase d = new DetailedPurchase();
        /** 进货单id*/
        // TODO: 2022/8/21 干啥的 
        Integer purchaseId = stokeServicec.listMaxPurchaseId();
        d.setPurchaseId(Long.valueOf(purchaseId) + 1);
        /** 用时间戳记录批次*/
        String TradeNo = String.valueOf(System.currentTimeMillis());
        d.setBatch(TradeNo);
        /** 设置经销商 */
        d.setVendorId(Long.valueOf(vendor));
        /** 设置skuId */
        d.setSkuId(Long.valueOf(goods));
        /** 设置价格 */
        Goodsku g = stokeServicec.listGoodSkuById(Integer.valueOf(goods));
        Price price = stokeServicec.listPriceById(g.getPriceId());
        d.setPurchasePrice(price.getPrice());
        /** 数量 */
        d.setNumber(Integer.valueOf(number));
        /**创建订单时订单状态为1*/
        d.setStatus(0);
        /**设置创建人和时间*/
        d.setCreateUserId(o.getId());
        d.setCreateTime(new Date());
        /**设置更新人和时间*/
        d.setUserRenewId(o.getId());
        d.setRenewTime(new Date());

        /**设置进货单*/
        //描述
        Purchase p = new Purchase();
        p.setPurchaseDesc(Desc);
        //进货数量
        p.setPurchaseNumber(Long.valueOf(number));
        //创建人
        p.setCreateUserId(o.getId());
        p.setCreateTime(new Date());
        //设置更新人和时间
        p.setUserRenewId(o.getId());
        p.setRenewTime(new Date());
        //审核人状态  刚申请  状态默认0
        p.setStatus(0);
        //审核人
        p.setExamineUserId(o.getId());
        p.setExamineTime(new Date());
        //审核意见
        p.setExamineOpinion("无");
        stokeServicec.addPurchase(p);
        /** 华丽的分界线 */
//        for (int i = 0; i <= 5; i++) {
//            System.out.println("===================================================================");
//            System.out.println(i+"=="+i+"=="+i+"=="+i+"=="+i+"=="+i+"=="+i+"=="+i+"=="+i+"=="+i+"=="+i+"=="+i+"=="+i+"=="+i+"=="+i+"=="+i+"=="+i+"=="+i+"=="+i+"=="+i+"=="+i+"=="+i+"=="+i);
//        }
//        System.out.println("===================================================================");
//
//        System.out.println(d);
        return stokeServicec.addDetailedPurchase(d);
    }

    /**
     * 遍历经销商
     */
    @RequestMapping("listVendor")
    @ResponseBody
    public List<Vendor> listVendor() {
        return stokeServicec.listVendor();
    }


    /**
     * 根据token查询id来判断是否能编辑和删除
     */
    @RequestMapping("tokenPowerId")
    @ResponseBody
    public Map<String, Object> tokenPowerId(String token) {
        Map<String, Object> map = new HashMap<>();
        //获得更改用户的信息
        User o = (User) redisTemplate.opsForValue().get(token);
        long roleId = o.getRoleId();
        map.put("roleId", roleId);
        return map;
    }

    @RequestMapping("updatePurchaseById")
    @ResponseBody
    public Integer updatePurchaseById(String token, Integer status, String opinion, Integer id, @RequestParam(required = false) Integer status2) {
        System.out.println("============================" + status);
        //获得更改用户的信息
        User o = (User) redisTemplate.opsForValue().get(token);
        long userId = o.getId();
        Date date = new Date();
        if (opinion == "") {
            opinion = "无";
        }
        if (status == 2) {
            stokeServicec.updateDetailedPurchase(status2, userId, date, id);
        }
        if(status == 1){
            stokeServicec.updateDetailedPurchase(1, userId, date, id);
        }
        return stokeServicec.updatePurchaseById(userId, o.getId(), id, status, opinion, date, date);
    }
}
