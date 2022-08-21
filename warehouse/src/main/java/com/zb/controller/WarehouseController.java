package com.zb.controller;

import com.zb.pojo.Warehouse;
import com.zb.service.WarehouseService;
import com.zb.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("warehoue")
@CrossOrigin
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    /**
     * 查询全部列表
     * @return
     */
    @GetMapping("findAll")
    public Result findAll(){
        List<Warehouse> list = warehouseService.findList();
        return new Result().setData(list).setMessage("success").setCode(200);
    }

    /**
     * 根据skuid查询列表
     * @return
     */
    @GetMapping("findBySkuId/{skuId}")
    public Result findBySkuId(@PathVariable("skuId") Long skuId){
        List<Warehouse> list = warehouseService.findBySkuIdWarehouses(skuId);
        return new Result().setData(list).setMessage("success").setCode(200);
    }

    @PostMapping("add")
    public Result add(@RequestBody Warehouse warehouse){
        Integer add = warehouseService.add(warehouse);
        if(add > 0){
            return new Result().setCode(200).setMessage("success");
        }else{
            return new Result().setCode(404).setMessage("添加失败");
        }
    }

}
