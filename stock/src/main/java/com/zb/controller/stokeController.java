package com.zb.controller;

import com.zb.pojo.DetailedPurchase;
import com.zb.pojo.Purchase;
import com.zb.service.StokeServicec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class stokeController {

    @Autowired(required = false)
    private StokeServicec stokeServicec;

    @RequestMapping("/showAllStoke")
    @ResponseBody
    public List<Purchase> showAllStoke() {
        return stokeServicec.listPurchase();
    }

    @RequestMapping("/listPurchaseDetailedPurchase")
    @ResponseBody
    public List<DetailedPurchase> listPurchaseDetailedPurchase() {
        return stokeServicec.listPurchaseDetailedPurchase();
    }

    @RequestMapping("/listPurchaseDetailedPurchaseById/{id}")
    @ResponseBody
    public List<DetailedPurchase> listPurchaseDetailedPurchaseById(@PathVariable("id") Long id) {
        return stokeServicec.listPurchaseDetailedPurchaseBylistPurchaseId(id);
    }
}
