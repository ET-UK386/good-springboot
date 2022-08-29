package com.zb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 1541
 * 颜色表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Color {

  private Long id;
  /** 颜色名称*/
  private String colorName;

  private Long createUserId;
  private Date createTime;
  private Long userRenewId;
  private Date renewTime;
  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getColorName() {
    return colorName;
  }

  public void setColorName(String colorName) {
    this.colorName = colorName;
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
}
