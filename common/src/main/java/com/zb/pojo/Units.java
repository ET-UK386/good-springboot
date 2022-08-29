package com.zb.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * 单位表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Units {

  private Integer id;
  /** 单位名称（时 分 秒， 千克 克 。。。）*/
  private String unitsName;
  /** 属于什么计量单位*/
  private String module;

  private Integer createUserId;
  private Date createTime;
  private Integer userRenewId;
  private Date renewTime;
  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUnitsName() {
    return unitsName;
  }

  public void setUnitsName(String unitsName) {
    this.unitsName = unitsName;
  }

  public String getModule() {
    return module;
  }

  public void setModule(String module) {
    this.module = module;
  }

  public Integer getCreateUserId() {
    return createUserId;
  }

  public void setCreateUserId(Integer createUserId) {
    this.createUserId = createUserId;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Integer getUserRenewId() {
    return userRenewId;
  }

  public void setUserRenewId(Integer userRenewId) {
    this.userRenewId = userRenewId;
  }

  public Date getRenewTime() {
    return renewTime;
  }

  public void setRenewTime(Date renewTime) {
    this.renewTime = renewTime;
  }
}
