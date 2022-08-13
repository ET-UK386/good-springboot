package com.zb.mapper;

import com.zb.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User login(@Param("username") String username, @Param("password") String password);

}
