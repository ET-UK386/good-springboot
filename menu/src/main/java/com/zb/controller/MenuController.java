package com.zb.controller;


import com.zb.pojo.Menu;
import com.zb.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
@CrossOrigin("*")
public class MenuController {
    @Autowired(required = false)
    private MenuService menuService;

    @RequestMapping("/listMenu")
    public List<Menu> listMenu() {
        return menuService.listMenu();
    }

    @RequestMapping("/listMenu2")
    public List<Menu> listMenu2() {
        return menuService.listMenu2();
    }

    @RequestMapping("/listMenu3")
    public List<Menu> listMenu3() {
        return menuService.listMenu3();
    }

    @RequestMapping("/listMenu4")
    public List<Menu> listMenu4() {
        return menuService.listMenu4();
    }
}
