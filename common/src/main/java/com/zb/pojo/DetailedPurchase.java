package com.zb.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 1541
 * 进货详细单
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class DetailedPurchase {

  private Long id;
  /** 进货单ID*/
  private Long purchaseId;
  /** 供应商ID*/
  private Long vendorId;
  private Long skuId;
  /** 批次*/
  private String batch;
  /** 购买价格*/
  private BigDecimal purchasePrice;
  /** 数量*/
  private Integer number;
  /** 状态*/
  private Integer status;

  private Long createUserId;
  private Date createTime;
  private Long userRenewId;
  private Date renewTime;



}
