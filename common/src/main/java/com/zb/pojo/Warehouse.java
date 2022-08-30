package com.zb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 仓库
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {

  private Integer id;
  /** 入库详细单ID*/
  private Long detailedWarehousingId;
  /** 库存数量*/
  private Integer stockNumber;
  /** 仓库地址*/
  private String warehouseAddress;
  /** 联系方式*/
  private String phone;
  /** 商品skuID*/
  private Long skuId;

  private Long createUserId;
  private Date createTime;
  private Long userRenewId;
  private Date renewTime;
  /** 批次*/
  private String batch;

  private DetailedWarehousing detailedWarehousing;
  private Goodsku goodsku;
  private User createUser;
  private User userRenew;

  public String getSkuNameStr(){
    if(goodsku == null || goodsku.getColor() == null){
      return null;
    }
    return goodsku.getSkuName() + "-" + goodsku.getColor().getColorName();
  }
}
