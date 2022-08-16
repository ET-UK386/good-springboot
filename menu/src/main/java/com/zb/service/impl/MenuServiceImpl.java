package com.zb.service.impl;


import com.zb.mapper.MenuMapper;
import com.zb.pojo.Menu;
import com.zb.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired(required = false)
    private MenuMapper menuMapper;
    @Override
    public List<Menu> listMenu() {
        return menuMapper.listMenu();
    }
    //权限获取收银员需要的列表
    @Override
    public List<Menu> listMenu2() {
        return menuMapper.listMenu2();
    }
    //权限获取验证员需要的列表



    @Override
    public List<Menu> listMenu3() {
        return menuMapper.listMenu3();
    }
    //权限获取理货员需要的列表
    @Override
    public List<Menu> listMenu4() {
        return menuMapper.listMenu4();
    }
}
