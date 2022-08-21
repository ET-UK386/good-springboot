package com.zb.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * spu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Goodspu {

  private Integer id;
  /** 商品名称*/
  private String goodName;
  /** 品牌*/
  private String brand;
  private Integer sortId;
  private Integer status;
  private Integer createUserId;
  private Date createTime;
  private Integer userRenewId;
  private Date renewTime;
  private Sort sort;
  private User user;
  private String statusStr;
  public String getStatusStr() {
    switch (status){
      case 0 : statusStr ="上架";
      break;
      case 1 : statusStr ="下架";
      break;
      case 2 : statusStr ="售罄";
      break;
      default:
        break;
    }
    return statusStr;
  }

  public void setStatusStr(String statusStr) {
    this.statusStr = statusStr;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getGoodName() {
    return goodName;
  }

  public void setGoodName(String goodName) {
    this.goodName = goodName;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Integer getSortId() {
    return sortId;
  }

  public void setSortId(Integer sortId) {
    this.sortId = sortId;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
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

  public Sort getSort() {
    return sort;
  }

  public void setSort(Sort sort) {
    this.sort = sort;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
