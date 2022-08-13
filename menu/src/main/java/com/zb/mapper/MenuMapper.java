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
}
