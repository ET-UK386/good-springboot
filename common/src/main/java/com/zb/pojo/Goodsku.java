package com.zb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zb.utils.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

/**
 * sku
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goodsku {

  private Integer id;
  /** spu ID*/
  private Integer spuId;
  /** sku 名称*/
  private String skuName;
  /** 描述*/
  private String skuDesc;
  /** 颜色ID*/
  private Integer colorId;
  /** 价表ID*/
  private Integer priceId;
  /** 销量*/
  private Integer salesVolume;
  /** 单位ID*/
  private Integer companyId;
  /** 生产商*/
  private String manufacturer;
  /** 供应商ID*/
  private Integer supplierId;

  private Integer createUserId;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date createTime;
  private Integer userRenewId;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date renewTime;

  private Integer logic_status;

  private Goodspu goodspu;
  private Sort sort;
  private User user;
  private Color color;
  private Price price;
  private Units units;
  private Result result;

  public Result getResult() {
    return result;
  }

  public void setResult(Result result) {
    this.result = result;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getSpuId() {
    return spuId;
  }

  public void setSpuId(Integer spuId) {
    this.spuId = spuId;
  }

  public String getSkuName() {
    return skuName;
  }

  public void setSkuName(String skuName) {
    this.skuName = skuName;
  }

  public String getSkuDesc() {
    return skuDesc;
  }

  public void setSkuDesc(String skuDesc) {
    this.skuDesc = skuDesc;
  }

  public Integer getColorId() {
    return colorId;
  }

  public void setColorId(Integer colorId) {
    this.colorId = colorId;
  }

  public Integer getPriceId() {
    return priceId;
  }

  public void setPriceId(Integer priceId) {
    this.priceId = priceId;
  }

  public Integer getSalesVolume() {
    return salesVolume;
  }

  public void setSalesVolume(Integer salesVolume) {
    this.salesVolume = salesVolume;
  }

  public Integer getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Integer companyId) {
    this.companyId = companyId;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public Integer getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(Integer supplierId) {
    this.supplierId = supplierId;
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

  public Integer getLogic_status() {
    return logic_status;
  }

  public void setLogic_status(Integer logic_status) {
    this.logic_status = logic_status;
  }

  public Goodspu getGoodspu() {
    return goodspu;
  }

  public void setGoodspu(Goodspu goodspu) {
    this.goodspu = goodspu;
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

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  public Units getUnits() {
    return units;
  }

  public void setUnits(Units units) {
    this.units = units;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Goodsku)) return false;
    Goodsku goodsku = (Goodsku) o;
    return Objects.equals(id, goodsku.id) &&
            Objects.equals(spuId, goodsku.spuId) &&
            Objects.equals(skuName, goodsku.skuName) &&
            Objects.equals(skuDesc, goodsku.skuDesc) &&
            Objects.equals(colorId, goodsku.colorId) &&
            Objects.equals(priceId, goodsku.priceId) &&
            Objects.equals(salesVolume, goodsku.salesVolume) &&
            Objects.equals(companyId, goodsku.companyId) &&
            Objects.equals(manufacturer, goodsku.manufacturer) &&
            Objects.equals(supplierId, goodsku.supplierId) &&
            Objects.equals(createUserId, goodsku.createUserId) &&
            Objects.equals(createTime, goodsku.createTime) &&
            Objects.equals(userRenewId, goodsku.userRenewId) &&
            Objects.equals(renewTime, goodsku.renewTime) &&
            Objects.equals(logic_status, goodsku.logic_status) &&
            Objects.equals(goodspu, goodsku.goodspu) &&
            Objects.equals(sort, goodsku.sort) &&
            Objects.equals(user, goodsku.user) &&
            Objects.equals(color, goodsku.color) &&
            Objects.equals(price, goodsku.price) &&
            Objects.equals(units, goodsku.units) &&
            Objects.equals(result, goodsku.result);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, spuId, skuName, skuDesc, colorId, priceId, salesVolume, companyId, manufacturer, supplierId, createUserId, createTime, userRenewId, renewTime, logic_status, goodspu, sort, user, color, price, units, result);
  }
}
