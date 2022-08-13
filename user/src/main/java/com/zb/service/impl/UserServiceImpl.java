package com.zb.service.impl;

import com.zb.mapper.UserMapper;
import com.zb.pojo.User;
import com.zb.service.UserService;
import javafx.beans.binding.StringExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;
    //登录
    @Override
    public User listUser(String username, String password) {
        return userMapper.listUser(username,password);
    }
    //添加收银员
    @Override
    public int addUserCashier(User u) {
        return userMapper.addUserCashier(u);
    }
    //添加验货员
    @Override
    public int addSurveyor(User u) {
        return userMapper.addSurveyor(u);
    }
    //添加理货员
    @Override
    public int addTally(User u) {
        return userMapper.addTally(u);
    }

    //修改用户


    @Override
    public int UpdateGetByUserId(User u) {
        return userMapper.UpdateGetByUserId(u);
    }


    @Override
    public List<User> ListCashier(String username, String address, String phone) {
        Map<String,Object> map=new HashMap<>();
        if(username!=null &&!"".equals(username.trim())){
            map.put("username",username);
        }
        if(address!=null &&!"".equals(address.trim())){
            map.put("address",address);
        }
        if(phone!=null &&!"".equals(phone.trim())){
            map.put("phone",phone);
        }


        return userMapper.ListCashier(map);
    }

    @Override
    public List<User> surveyor(String username, String address, String phone) {
        Map<String,Object> map=new HashMap<>();
        if(username!=null &&!"".equals(username.trim())){
            map.put("username",username);
        }
        if(address!=null &&!"".equals(address.trim())){
            map.put("address",address);
        }
        if(phone!=null &&!"".equals(phone.trim())){
            map.put("phone",phone);
        }

        return userMapper.surveyor(map);
    }


    //三表查询全部理货员
    @Override
    public List<User> tally(String username, String address, String phone) {
        Map<String,Object> map=new HashMap<>();
        if(username!=null &&!"".equals(username.trim())){
            map.put("username",username);
        }
        if(address!=null &&!"".equals(address.trim())){
            map.put("address",address);
        }
        if(phone!=null &&!"".equals(phone.trim())){
            map.put("phone",phone);
        }
        return userMapper.tally(map);
    }

    @Override
    public List<User> userList() {
        return userMapper.userList();
    }

    //修改用户显示状态为0

    @Override
    public int deleteByid(int id) {
        return userMapper.deleteByid(id);
    }

    //根据id查询
    @Override
    public User userGetById(int id) {
        return userMapper.userGetById(id);
    }
}
