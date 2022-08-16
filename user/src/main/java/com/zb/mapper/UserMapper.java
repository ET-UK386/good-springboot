package com.zb.mapper;

import com.zb.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User listUser(@Param("username") String username, @Param("password") String password);

    //三表查询全部收银员
    List<User> ListCashier(Map<String, Object> map);
    int countListCashier(Map<String, Object> map);

    //三表查询全部验货员
    List<User> surveyor(Map<String, Object> map);
    int countListsurveyor(Map<String, Object> map);



    //三表查询全部理货员
    List<User> tally(Map<String, Object> map);
    int countListtally(Map<String, Object> map);



    //查询用户表
    List<User> userList();



    /**
     * 添加收银行用户
     * @return
     */
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

    /**
     * 修用户信息
     * @return
     */
    int UpdateGetByUserId(User u);

    //修改用户显示状态为0
    int deleteByid(int id);

    //根据id查询
    User userGetById(int id);


}

