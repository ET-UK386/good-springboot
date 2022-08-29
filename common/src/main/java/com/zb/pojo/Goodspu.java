package com.zb.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Date;

public class Goodspu {

  private Integer id;
  private String goodName;
  private String brand;
  private Integer sortId;
  private Integer status;
  private Integer createUserId;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date createTime;
  private Integer userRenewId;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date renewTime;
  private Integer colorId;
  private Integer priceId;
  private Integer companyId;
  private String con3;
  private Sort sort;
  private Color color;
  private Units units;
  private User user;
  private Price price;

  public Integer getPriceId() {
    return priceId;
  }

  public void setPriceId(Integer priceId) {
    this.priceId = priceId;
  }

  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
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



  public Integer getUserRenewId() {
    return userRenewId;
  }

  public void setUserRenewId(Integer userRenewId) {
    this.userRenewId = userRenewId;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getRenewTime() {
    return renewTime;
  }

  public void setRenewTime(Date renewTime) {
    this.renewTime = renewTime;
  }

  public Integer getColorId() {
    return colorId;
  }

  public void setColorId(Integer colorId) {
    this.colorId = colorId;
  }

  public Integer getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Integer companyId) {
    this.companyId = companyId;
  }

  public String getCon3() {
    return con3;
  }

  public void setCon3(String con3) {
    this.con3 = con3;
  }

  public Sort getSort() {
    return sort;
  }

  public void setSort(Sort sort) {
    this.sort = sort;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Units getUnits() {
    return units;
  }

  public void setUnits(Units units) {
    this.units = units;
  }
}
