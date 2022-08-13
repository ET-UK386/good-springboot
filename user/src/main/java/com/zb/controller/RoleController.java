package com.zb.controller;

import com.zb.pojo.Role;
import com.zb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //查询角色表全部

    @RequestMapping("listRole")
    public  List<Role> listRole(){
        return  roleService.listRole();
    }

}
