package com.zb.controller;

import com.zb.pojo.*;
import com.zb.service.GoodService;
import com.zb.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/goodsku")
@CrossOrigin("*")
public class GoodController {

    @Resource
    private GoodService goodService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    //显示商品信息
    @RequestMapping("/listGoodsku")
    public List<Goodsku> listGoodsku(){
        List<Goodsku> list = goodService.listGood();
        return list;
    }
    //显示商品spu
    @RequestMapping("/listGoodSpu")
    public List<Goodspu> listGoodSpu(){
       return goodService.listGoodSpu();
    }

    //查找全部颜色
    @RequestMapping("/listColor")
    public List<Color> listColor(){
       return goodService.listColor();
    }
    //查找全部分类
    @RequestMapping("/listSort")
    public List<Sort> listSort(){
        return goodService.listSort();
    }

    //查找全部单位
    @RequestMapping("/listUnits")
    public List<Units> listUnits(){
        return goodService.listUnits();
    }

    //查找全部商品名
    @RequestMapping("/listGoodSpus")
    public List<Goodspu> listGoodSpus(){
        return goodService.listGoodspu();
    }

    /**
     * 商品详细信息
     * @return
     */
    @RequestMapping("/findAllGoodsku")
    public List<Goodsku> findAllGoodsku(){
       return goodService.findAllGoodsku();
    }

    //逻辑删除
    @RequestMapping("/del")
    public int updateLogic_status(Integer id){
       return goodService.updateLogic_status(id);
    }

    //根据商品名或分类名查询
    @RequestMapping("/fingByskuNameorSortName")
    public List<Goodsku> fingByskuNameorSortName(String skuName,String sortName){
        List<Goodsku> goodskus = goodService.fingByskuNameorSortName(skuName,sortName);
        return goodskus;
    }

    //添加spu
    @RequestMapping("/insertGoodSpu")
    public int insertGoodSpu(@RequestBody(required = false) Goodspu p){

        if(p.getSortId() == null){
            //将传过来的对象里的sortName 存入sort对象中
            p.getSort().setSortName(p.getSort().getSortName());
            Sort sort = goodService.findSort(p.getSort().getSortName());
            p.setSortId(sort.getId());
        }
        p.setGoodName(p.getGoodName());
        p.setBrand(p.getBrand());
        p.setCreateUserId(1L);
        p.setCreateTime(new Date());
        p.setUserRenewId(1L);
        p.setRenewTime(new Date());
        return goodService.insertGoodspu(p);
    }

    /**
     * 添加颜色
     * @param c
     * @return
     */
    @RequestMapping("/insertColor")
    public Result insertcolor(@RequestBody(required = false) Color c){
        Color color = goodService.findColorTwo(c.getColorName());
        if(color != null && c.getColorName().equals(color.getColorName())){
            Result result = new Result();
            result.setMessage("当前颜色已存在");
            result.setCode(404);
            return result;
        }
            User o =(User) redisTemplate.opsForValue().get(c.getToken());
            c.setCreateUserId(o.getId());
            c.setCreateTime(new Date());
            c.setUserRenewId(o.getId());
            c.setRenewTime(new Date());

        int i = goodService.insertColor(c);
        if(i == 1){
            return new Result("添加成功",200);
        }else {
            return new Result("添加失败",200);
        }
    }


    /**
     * 添加分类
     * @param s @return
     */
    @RequestMapping("/insertSort")
    public Result insertSort(@RequestBody(required = false) Sort s){
        Sort sortTwo = goodService.findSortTwo(s.getSortName());
        if(sortTwo != null && s.getSortName().equals(sortTwo.getSortName())){
            Result result = new Result();
            result.setMessage("当前分类已存在");
            result.setCode(404);
            return result;
        }
        User o =(User) redisTemplate.opsForValue().get(s.getToken());
        s.setCreateUserId(o.getId());
        s.setCreateTime(new Date());
        s.setUserRenewId(o.getId());
        s.setRenewTime(new Date());

        int i = goodService.insertSort(s);
        if(i == 1){
            return new Result("添加成功",200);
        }else {
            return new Result("添加失败",200);
        }
    }

    /**
     * 添加单位
     * @param u
     * @return
     */
    @RequestMapping("/insertUnits")
    public Result insertUnits(@RequestBody(required = false) Units u){
        Units unitsTwo = goodService.findUnitsTwo(u.getUnitsName());
        if(unitsTwo != null && u.getUnitsName().equals(unitsTwo.getUnitsName())){
            Result result = new Result();
            result.setMessage("当前单位已存在");
            result.setCode(404);
            return result;
        }
        User o =(User) redisTemplate.opsForValue().get(u.getToken());
        u.setCreateUserId(o.getId());
        u.setCreateTime(new Date());
        u.setUserRenewId(o.getId());
        u.setRenewTime(new Date());

        int i = goodService.insertUnits(u);
        if(i == 1){
            return new Result("添加成功",200);
        }else {
            return new Result("添加失败",200);
        }
    }

    /**
     * 添加
     * @param g
     * @return
     */
    @RequestMapping ("/insertGood")
    public Result insertGood(@RequestBody(required = false)Goodsku g){
        //如果spuId 等于空的时候
        if(g.getSpuId() == null){
            if(g.getSort().getSortName() == null){
                g.getSort().setSortName(g.getSort().getSortName());
                goodService.insertSort(g.getSort());
                g.getGoodspu().setSortId(g.getGoodspu().getSort().getId());
            }else{
                Sort sort = goodService.findSort(g.getSort().getSortName());
                g.getGoodspu().setSortId(sort.getId());
            }
            g.getGoodspu().setGoodName(g.getSkuName());
            System.out.println(g.getGoodspu().toString());
            goodService.insertGoodspu(g.getGoodspu());
            g.setSpuId(g.getGoodspu().getId());
        }
        if(g.getColorId() == null){
            Color color = goodService.findColor(g.getColor().getColorName());
            g.getColor().setId(color.getId());
            g.setColorId(g.getColor().getId());
        }
        if(g.getPriceId() == null) {
            Price priceTwo = goodService.findPriceTwo(g.getPrice().getPrice());
            if(priceTwo == null){
                g.getPrice().setSkuId(g.getGoodspu().getId());
                g.getPrice().setSkuId(g.getSpuId());
                goodService.insertprice(g.getPrice());
                g.setPriceId(g.getPrice().getId());
            }else{
                Price priceTwo1 = goodService.findPriceTwo(g.getPrice().getPrice());
                g.getPrice().setId(priceTwo1.getId());
                g.setPriceId(g.getPrice().getId());
            }
        }
        Goodspu goodName = goodService.findGoodName(g.getSpuId());
        g.setSkuName(g.getSkuName());
        Goodsku goodsku = goodService.listBySkuName(g.getSkuName(),g.getColorId(),g.getPriceId());
        if(goodsku != null && goodsku.getSkuName().equals(g.getSkuName()) && goodsku.getColorId().equals(g.getColorId()) && goodsku.getPriceId().equals(g.getPriceId())){
            Result result = new Result();
            result.setMessage("该商品已存在");
            result.setCode(404);
            return result;
        }
        if(g.getCompanyId() == null){
            Units units = goodService.findUnits(g.getUnits().getUnitsName());
            g.getUnits().setId(units.getId());
            g.setCompanyId(g.getUnits().getId());
        }
        g.setCreateUserId(1L);
        g.setCreateTime(new Date());
        g.setUserRenewId(1L);
        g.setRenewTime(new Date());
        int i =  goodService.insertGood(g);
        if(i == 1){
            return new Result("添加成功",200);
        }else{
            return new Result("添加失败",404);
        }
    }

    /**
     * 根据spu_id获取sku对象
     * @return
     */
    @RequestMapping("/listByid")
    public Goodsku listByid(@RequestBody(required = false)Goodsku g){
       return goodService.listByid(g.getId());
    }

    /**
     * 根据id修改
     * @param g
     * @return
     */
    @RequestMapping("/updateGood")
    public int updateGood(@RequestBody(required = false) Goodsku g){
        System.out.println(g.toString());
        if(g != null){
            Goodspu findspu = goodService.findspu(g.getSpuId());
            findspu.setBrand(g.getGoodspu().getBrand());
            findspu.setSortId(g.getGoodspu().getSortId());
            goodService.updateSpu(findspu);
            g.setSpuId(findspu.getId());
            g.setSpuId(g.getSpuId());
            g.setColorId(g.getColorId());
            g.getGoodspu().setSortId(g.getGoodspu().getSortId());
            g.getGoodspu().setBrand(g.getGoodspu().getBrand());
            g.setCompanyId(g.getCompanyId());
            g.setSkuName(g.getSkuName());
            g.setSkuDesc(g.getSkuDesc());
            g.getPrice().setPrice(g.getPrice().getPrice());
            int id = goodService.findPrice(g.getPrice().getPrice());
            if(id == 0){
                Goodspu findspu1 = goodService.findspu(g.getGoodspu().getId());
                g.getPrice().setSkuId(g.getSpuId());
                g.getPrice().setPrice(g.getPrice().getPrice());
                goodService.insertprice(g.getPrice());
                Price priceTwo = goodService.findPriceTwo(g.getPrice().getPrice());
                g.setPriceId(g.getPrice().getId());
                g.getPrice().setId(priceTwo.getId());
                goodService.updateGoodskuPrice(g);
                g.setPriceId(priceTwo.getId());
            } else {
                Price priceTwo = goodService.findPriceTwo(g.getPrice().getPrice());
                g.setPriceId(priceTwo.getId());
            }
        }
       g.setUserRenewId(1L);
       g.setRenewTime(new Date());
        g.setId(g.getId());
       return goodService.updateGood(g);
    }

}
