package com.zb.controller;

import com.zb.pojo.Warehousing;
import com.zb.service.WarehousingService;
import com.zb.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("warehousing")
@CrossOrigin
public class WarehousingController {

    @Autowired
    private WarehousingService warehousingService;

    @GetMapping("/findAll")
    public Result findAll(){
        List<Warehousing> list = warehousingService.findAll();
        return new Result().setCode(200).setData(list).setMessage("success");
    }
}