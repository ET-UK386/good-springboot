package com.zb.mapper;

import com.zb.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {
    //查询角色表全部
    List<Role> listRole();
}
