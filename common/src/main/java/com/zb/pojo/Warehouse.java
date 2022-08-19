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

  private Long id;
  /** 进货详细单ID*/
  private Long detailedPurchaseId;
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

  private DetailedPurchase detailedPurchase;
  private Goodsku goodsku;
  private User createUser;
  private User userRenew;
}
