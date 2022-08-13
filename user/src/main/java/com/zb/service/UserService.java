package com.zb.service;


import com.zb.pojo.User;

public interface UserService {
    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User login(String username, String password);
}
