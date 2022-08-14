package com.zb.service;

import com.zb.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User listUser(String username, String password);

    //添加新收银员
    int addUserCashier(User u);


    /**
     * 添加验货员用户
     * @return
     */
    int addSurveyor(User u);

    /**
     * 添加理货员用户
     * @return
     */
    int addTally(User u);






    //修改用户信息
    int UpdateGetByUserId(User u);

    //查询用户表
    List<User> userList();



    //查询全部收银员
    List<User> ListCashier(String username, String address, String phone);


    //查询全部验员
    List<User> surveyor(String username, String address, String phone);

    //三表查询全部理货员
    List<User> tally(String username, String address, String phone);

    //修改用户显示状态为0
    int deleteByid(int id);

    //根据id查询
    User userGetById(int id);
}
