package com.zb.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Transient;

import java.util.Date;

/**
 * 用户表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    /** 角色id*/
    private Long roleId;
    /** 用户名*/
    private String username;
    /** 密码*/
    private String password;
    /** 地址*/
    private String address;
    /** 手机号*/
    private String phone;

    private Long createUserId;
    private Date createTime;
    private Long userRenewId;
    private Date renewTime;
    @Transient
    private String userRenewName;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUserRenewId() {
        return userRenewId;
    }

    public void setUserRenewId(Long userRenewId) {
        this.userRenewId = userRenewId;
    }

    public Date getRenewTime() {
        return renewTime;
    }

    public void setRenewTime(Date renewTime) {
        this.renewTime = renewTime;
    }

    public String getUserRenewName() {
        return userRenewName;
    }

    public void setUserRenewName(String userRenewName) {
        this.userRenewName = userRenewName;
    }
}
