package com.zb.controller;

import com.zb.pojo.Units;
import com.zb.service.UnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/units")
public class UnitsController {
    @Autowired(required = false)
    private UnitsService unitsService;

    //查询
    @RequestMapping("/listUnits")
    public List<Units> listUnits(){
        return unitsService.listUnits();
    }
}
