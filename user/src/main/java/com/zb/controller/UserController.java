package com.zb.controller;

import com.zb.pojo.User;
import com.zb.service.UserService;
import com.zb.utils.Result;
import com.zb.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin("*")
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping("login")
    public Result login(@RequestBody User user){
        String username = user.getUsername();
        String password = user.getPassword();
        User loginUser = userService.login(username, password);

        if(!ObjectUtils.isEmpty(loginUser)){
            // 有该用户
            // 获取token
            String token = TokenUtil.getToken();
            // 存入redis
            redisTemplate.opsForValue().set(token, loginUser,3, TimeUnit.HOURS);

            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            map.put("loginUser",loginUser);
            return new Result().setMessage("登录成功").setData(map).setCode(200);
        }else{
            // 没查询到该用户
            return new Result().setMessage("用户名或密码错误").setCode(404);
        }
    }

}
