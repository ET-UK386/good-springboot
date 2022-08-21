package com.zb.service.impl;

import com.zb.mapper.RoleMapper;
import com.zb.pojo.Role;
import com.zb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    //查询角色表全部

    @Override
    public List<Role> listRole() {
        return roleMapper.listRole();
    }
}
