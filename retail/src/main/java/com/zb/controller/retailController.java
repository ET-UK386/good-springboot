package com.zb.controller;


import com.zb.pojo.SalesDetails;
import com.zb.service.retailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class retailController {

    @Autowired(required = false)
    private retailService retailService;

    /**
     * 查询全部
     *
     * @return
     */
    @RequestMapping("listSalesDetails")
    @ResponseBody
    public List<SalesDetails> listSalesDetails() {
        return retailService.listSalesDetails();
    }

    /**
     * 根据条件查询全部
     *
     * @param name
     * @return
     */
    @RequestMapping("listSalesDetailsByName")
    @ResponseBody
    public List<SalesDetails> listSalesDetailsByName(@RequestParam("name") String name) {
        return retailService.listSalesDetailsByName(name);
    }

    /**
     * 根据id查询单个
     *
     * @param id
     * @return
     */
    @RequestMapping("listSalesDetailsById")
    @ResponseBody
    public List<SalesDetails> listSalesDetailsById(@RequestParam("id") Integer id) {
        return retailService.listSalesDetailsById(id);
    }


    /**
     * 修改为已签收
     *
     * @param id
     * @return
     */
    @RequestMapping("updateSalesDetailsById")
    @ResponseBody
    public Integer updateSalesDetailsById(@RequestParam("id") Integer id, @RequestParam("status") String status) {
        return retailService.updateSalesDetailsById(id);
    }
}
