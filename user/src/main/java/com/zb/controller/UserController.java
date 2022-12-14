package com.zb.controller;

import com.zb.pojo.User;
import com.zb.service.UserService;
import com.zb.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin("*")
@RequestMapping("user")
@CacheConfig(cacheNames = "userinfoCache")
public class UserController {


    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping("login")
    public  Map<String, Object>  login(@RequestBody User user, HttpSession session, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        String username = user.getUsername();
        String password = user.getPassword();
        User loginUser = userService.listUser(username,password);
        session.setAttribute("loginUser",loginUser);

        if(!ObjectUtils.isEmpty(loginUser)){
            // 有该用户
            // 获取token
            String token = TokenUtil.getToken();
            // 存入redis
            redisTemplate.opsForValue().set(token, loginUser,3, TimeUnit.HOURS);




            map.put("token", token);
            map.put("username",username);
            map.put("flag","success");
        }else{
            //登录失败
            map.put("flag","error");
            map.put("msg","用户名或密码不正确");
        }
        return  map;
    }

    //添加用户
    @RequestMapping("addUserCashier")
    public  int addUserCashier(@RequestBody(required = false) User u){

        User o = (User) redisTemplate.opsForValue().get(u.getToken());

        u.setCreateTime(new Date());
        u.setCreateUserId(o.getId());
        u.setRenewTime(new Date());
        u.setUserRenewId(o.getId());
        return   userService.addUserCashier(u);
    }

    //添加验货员
    @RequestMapping("addSurveyor")
    public  int addSurveyor(@RequestBody(required = false) User u){

        User o = (User) redisTemplate.opsForValue().get(u.getToken());

        u.setCreateTime(new Date());
        u.setCreateUserId(o.getId());
        u.setRenewTime(new Date());
        u.setUserRenewId(o.getId());
        return   userService.addSurveyor(u);
    }

    //添加理货员
    @RequestMapping("addTally")
    public  int addTally(@RequestBody(required = false) User u){

        User o = (User) redisTemplate.opsForValue().get(u.getToken());

        u.setCreateTime(new Date());
        u.setCreateUserId(o.getId());
        u.setRenewTime(new Date());
        u.setUserRenewId(o.getId());
        return   userService.addTally(u);
    }








    //修改用户
    @RequestMapping("updateUserByid")
    public  int updateUserByid(@RequestBody(required = false) User u){


        User o = (User) redisTemplate.opsForValue().get(u.getToken());

        u.setUserRenewId(o.getId());
        u.setRenewTime(new Date());
        return  userService.UpdateGetByUserId(u);
    }

    //查询全部收银员

    @RequestMapping("ListCashier")
    public  Map<String ,Object> ListCashier( String username,String address,String phone,
                                     int currentPage,int pageSize ){
        Map<String ,Object> map=new HashMap<>();
        int countCashier=userService.countListCashier(username,address,phone);
          List<User> listCashier=userService.ListCashier(username,address,phone,currentPage,pageSize);
          map.put("countCashier",countCashier);
        map.put("listCashier",listCashier);
        return  map;
    }

    //查询全部验货员

    @RequestMapping("Listsurveyor")
    public  Map<String ,Object>  Listsurveyor(String username,String address,String phone,
                                   int currentPage,int pageSize){
        Map<String ,Object> map=new HashMap<>();
          List<User> listsurveyor=userService.surveyor(username,address,phone, currentPage, pageSize);
          int countListsurveyor=userService.countListsurveyor( username, address, phone);
          map.put("listsurveyor",listsurveyor);
        map.put("countListsurveyor",countListsurveyor);
          return  map;
    }


    //查询全部理货员

    @RequestMapping("Listtally")
    public  Map<String ,Object>  tally(String username,String address,String phone,
                                       int currentPage,int pageSize){
         Map<String ,Object> map=new HashMap<>();
          List<User> listally=userService.tally(username,address,phone,currentPage,pageSize);
          int countlistally=userService.countListtally(username,address,phone);
          map.put("listally",listally);
          map.put("countlistally",countlistally);
          return  map;
    }




    //查询user单表的全部
    @RequestMapping("userList")
    public List<User> userList(){
        return userService.userList();
    }


    //修改显示状态
    @RequestMapping("deleteByid")
    public  int deleteByid(int id){
        return  userService.deleteByid(id);
    }



    //根据id查询

    @RequestMapping("userGetById")
    public  User userGetById(int id){
        return  userService.userGetById(id);
    }

    //查询token里面的权限id
    @RequestMapping("tokenPowerId")
    public  Map<String,Object> tokenPowerId(String token){
        Map<String,Object> map=new HashMap<>();
        System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊"+token);
        User o = (User) redisTemplate.opsForValue().get(token);
        System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊"+o);
        Long powerid=o.getRole().getUserPower();
        map.put("powerid",powerid);
        System.out.println(powerid);
        return map;

    }



}

