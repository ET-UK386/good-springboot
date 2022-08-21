package com.zb.controller;

import com.zb.mapper.GoodMapper;
import com.zb.pojo.*;
import com.zb.service.GoodService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goodsku")
@CrossOrigin("*")
public class GoodController {

    @Autowired
    private GoodService goodService;

    //分页显示数据
    @RequestMapping("/listGoodsku")
    public List<Goodsku> listGoodsku(){
        List<Goodsku> list = goodService.listGood();
        return list;
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

    /**
     * 添加
     * @param g
     * @return
     */
    @RequestMapping ("/insertGood")
    public int insertGood(@RequestBody(required = false)Goodsku g){
        System.out.println(g.toString());
        //如果spuId 等于空的时候
        if(g.getSpuId() == null){
            if(g.getGoodspu().getSort().getSortName() == null){
                g.getGoodspu().getSort().setSortName(g.getGoodspu().getSort().getSortName());
                int sortId = goodService.insertSort(g.getGoodspu().getSort());
                g.getGoodspu().setSortId(sortId);
            }else{
                Sort sort = goodService.findSort(g.getGoodspu().getSort().getSortName());
                g.getGoodspu().setSortId(sort.getId());
            }
            g.getGoodspu().setGoodName(g.getSkuName());
            g.getGoodspu().setStatus(g.getGoodspu().getStatus());
            goodService.insertGoodspu(g.getGoodspu());
            g.setSpuId(g.getGoodspu().getId());
        }
        if(g.getColorId() == null){
            Color color = goodService.findColor(g.getColor().getColorName());
            g.getColor().setId(color.getId());
            g.setColorId(g.getColor().getId());
        }
        if(g.getPriceId() == null){
            g.getPrice().setSkuId(g.getGoodspu().getId());
            goodService.insertprice(g.getPrice());
            g.setPriceId(g.getPrice().getId());
        }
        if(g.getStockId() == null){
            goodService.insertStock(g.getWarehouse());
            g.setStockId(g.getWarehouse().getId());
        }
        g.setSalesVolume(g.getSalesVolume());
        if(g.getCompanyId() == null){
            Units units = goodService.findUnits(g.getUnits().getUnitsName());
            g.getUnits().setId(units.getId());
            g.setCompanyId(g.getUnits().getId());
        }
        if(g.getSupplierId() == null){
            goodService.insertvendor(g.getVendor());
            g.setSupplierId(g.getVendor().getId());
        }
        g.setSalesVolume(g.getSalesVolume());
        g.setCreateUserId(1);
        g.setCreateTime(new Date());
        g.setUserRenewId(1);
        g.setRenewTime(new Date());
        return goodService.insertGood(g);
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
            Sort sort = goodService.findSort(g.getGoodspu().getSort().getSortName());
            sort.setSortName(g.getGoodspu().getSort().getSortName());
            System.out.println(sort.toString());
            goodService.updateSort(sort);
            Goodspu findspu = goodService.findspu(g.getGoodspu().getId());
            findspu.setBrand(g.getGoodspu().getBrand());
            findspu.setStatus(g.getGoodspu().getStatus());
            findspu.setSortId(sort.getId());
            goodService.updateSpu(findspu);
            g.setSpuId(findspu.getId());
            g.setSkuName(g.getSkuName());
            g.setSkuDesc(g.getSkuDesc());
            g.getColor().setColorName(g.getColor().getColorName());
            Color color = goodService.findColor(g.getColor().getColorName());
            color.setColorName(g.getColor().getColorName());
            goodService.updateColor(color);
            g.setColorId(color.getId());
            g.getPrice().setPrice(g.getPrice().getPrice());
            int id = goodService.findPrice(g.getPrice().getPrice());
            if(id == 0){
                Goodspu findspu1 = goodService.findspu(g.getGoodspu().getId());
                g.getPrice().setSkuId(findspu.getId());
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
            if(g.getStockId() == null){
                int warehouseTwo = goodService.findWarehouseTwo(g.getWarehouse().getStockNumber());
                if(warehouseTwo == 0){
                    g.getWarehouse().setStockNumber(g.getWarehouse().getStockNumber());
                    goodService.insertStock(g.getWarehouse());
                    Warehouse warehouse = goodService.findWarehouse(g.getWarehouse().getStockNumber());
                    warehouse.setStockNumber(g.getWarehouse().getStockNumber());
                    goodService.updateWarehouse(warehouse);
                    g.setStockId(warehouse.getId());
                }else{
                    Warehouse warehouse = goodService.findWarehouse(g.getWarehouse().getStockNumber());
                    g.setStockId(warehouse.getId());
                }
            }
            g.setSalesVolume(g.getSalesVolume());
            g.getUnits().setUnitsName(g.getUnits().getUnitsName());
            Units units = goodService.findUnits(g.getUnits().getUnitsName());
            units.setUnitsName(g.getUnits().getUnitsName());
            goodService.updateUnits(units);
            g.setCompanyId(units.getId());

        }
        g.setManufacturer(g.getManufacturer());

        if(g.getSupplierId() == null){
            int vendor = goodService.findVendor(g.getVendor().getVendorName());
            if(vendor == 0){
                g.getVendor().setVendorName(g.getVendor().getVendorName());
                g.getVendor().setTel(g.getVendor().getTel());
                goodService.insertvendor(g.getVendor());
                Vendor vendorTwo = goodService.findVendorTwo(g.getVendor().getVendorName());
                vendorTwo.setTel(g.getVendor().getTel());
                vendorTwo.setVendorName(g.getVendor().getVendorName());
                goodService.updateVendor(vendorTwo);
                g.setSupplierId(vendorTwo.getId());
            }else{
                Vendor vendorTwo = goodService.findVendorTwo(g.getVendor().getVendorName());
                g.setSupplierId(vendorTwo.getId());
            }
        }

       g.setUserRenewId(1);
       g.setRenewTime(new Date());
        g.setId(g.getId());
       return goodService.updateGood(g);
    }

}
