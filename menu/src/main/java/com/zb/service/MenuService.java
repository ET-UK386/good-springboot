package com.zb.service;


import com.zb.pojo.Menu;

import java.util.List;

public interface MenuService {
    //获取列表
    List<Menu> listMenu();

    //权限获取收银货列表2
    List<Menu> listMenu2();

    //权限获取验证员需要的列表
    List<Menu> listMenu3();
    //权限获取理货员需要的列表
    List<Menu> listMenu4();
}
