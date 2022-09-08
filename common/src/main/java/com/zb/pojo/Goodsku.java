package com.zb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zb.utils.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * sku
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goodsku {

  private Long id;
  /** spu ID*/
  private Long spuId;
  /** sku 名称*/
  private String skuName;
  /** 描述*/
  private String skuDesc;
  /** 颜色ID*/
  private Long colorId;
  /** 价表ID*/
  private Long priceId;
  /** 销量*/
  private Integer salesVolume;
  /** 单位ID*/
  private Long companyId;
  /** 生产商*/
  private String manufacturer;
  /** 供应商ID*/
  private Long supplierId;

  private Long createUserId;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date createTime;
  private Long userRenewId;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date renewTime;

  private Integer logic_status;

  private Goodspu goodspu;

  public List<ImagesFk> getImagesFks() {
    return imagesFks;
  }

  public void setImagesFks(List<ImagesFk> imagesFks) {
    this.imagesFks = imagesFks;
  }

  private Sort sort;
  private User user;
  private Color color;
  private Price price;
  private Units units;
  private Result result;
  private List<ImagesFk> imagesFks;

  /**
   * 不能删
   * @return
   */
  public String getSkuNameStr(){
    if(getColor() == null){
      return null;
    }
    return this.getSkuName() + "-" + this.getColor().getColorName();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getSpuId() {
    return spuId;
  }

  public void setSpuId(Long spuId) {
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

  public Long getColorId() {
    return colorId;
  }

  public void setColorId(Long colorId) {
    this.colorId = colorId;
  }

  public Long getPriceId() {
    return priceId;
  }

  public void setPriceId(Long priceId) {
    this.priceId = priceId;
  }

  public Integer getSalesVolume() {
    return salesVolume;
  }

  public void setSalesVolume(Integer salesVolume) {
    this.salesVolume = salesVolume;
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public Long getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(Long supplierId) {
    this.supplierId = supplierId;
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

  public Result getResult() {
    return result;
  }

  public void setResult(Result result) {
    this.result = result;
  }
}
