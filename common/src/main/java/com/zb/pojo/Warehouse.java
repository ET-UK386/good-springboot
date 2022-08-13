package com.zb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 仓库
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Warehouse {

  private Integer id;
  /** 进货详细单ID*/
  private Integer detailedPurchaseId;
  /** 库存数量*/
  private Integer stockNumber;
  /** 仓库地址*/
  private String warehouseAddress;
  /** 联系方式*/
  private String phone;

  private Integer createUserId;
  private Date createTime;
  private Integer userRenewId;
  private Date renewTime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getDetailedPurchaseId() {
    return detailedPurchaseId;
  }

  public void setDetailedPurchaseId(Integer detailedPurchaseId) {
    this.detailedPurchaseId = detailedPurchaseId;
  }

  public Integer getStockNumber() {
    return stockNumber;
  }

  public void setStockNumber(Integer stockNumber) {
    this.stockNumber = stockNumber;
  }

  public String getWarehouseAddress() {
    return warehouseAddress;
  }

  public void setWarehouseAddress(String warehouseAddress) {
    this.warehouseAddress = warehouseAddress;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
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
