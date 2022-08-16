package com.zb.mapper;

import com.zb.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuMapper {
    //获取列表
    List<Menu> listMenu();
    //权限获取收银员需要的列表
    List<Menu> listMenu2();
    //权限获取验证员需要的列表
    List<Menu> listMenu3();
    //权限获取理货员需要的列表
    List<Menu> listMenu4();
}
