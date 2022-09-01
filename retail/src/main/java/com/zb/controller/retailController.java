package com.zb.controller;


import com.zb.pojo.SalesDetails;
import com.zb.service.retailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class retailController {

    @Autowired(required = false)
    private retailService retailService;

    @RequestMapping("listSalesDetails")
    @ResponseBody
    public List<SalesDetails> listSalesDetails() {
        return retailService.listSalesDetails();
    }

}
