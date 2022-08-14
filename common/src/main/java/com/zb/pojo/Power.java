package com.zb.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 权限表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Power {

  private Long id;
  private Long roleId;
  private String canUse;
  private Long createUserId;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date createTime;
  private Long userRenewId;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date renewTime;
  private String con1;
  private String con2;
  private String con3;

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

  public String getCanUse() {
    return canUse;
  }

  public void setCanUse(String canUse) {
    this.canUse = canUse;
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

  public String getCon1() {
    return con1;
  }

  public void setCon1(String con1) {
    this.con1 = con1;
  }

  public String getCon2() {
    return con2;
  }

  public void setCon2(String con2) {
    this.con2 = con2;
  }

  public String getCon3() {
    return con3;
  }

  public void setCon3(String con3) {
    this.con3 = con3;
  }
}
