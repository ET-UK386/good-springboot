package com.zb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * sku
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
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
  /** 库存表ID*/
  private Integer stockId;
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

  private Goodspu goodspu;
  private Sort sort;
  private User user;
  private Color color;
  private Price price;
  private Warehouse warehouse;
  private Units units;
  private Vendor vendor;

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

  public Integer getStockId() {
    return stockId;
  }

  public void setStockId(Integer stockId) {

  }
}
