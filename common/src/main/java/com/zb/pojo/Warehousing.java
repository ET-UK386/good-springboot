package com.zb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 入库流程
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Warehousing {

  private Long id;
  /** 进货单ID*/
  private Long purchaseId;
  /** 进货详细单ID*/
  private Long detailedPurchaseId;
  /** 审核人ID*/
  private Long examineUserId;
  /** 审核时间*/
  private Date examineTime;
  /** 入库人*/
  private Long warehousingUserId;
  /** 入库时间*/
  private Date warehousingTime;
  /** 入库数量*/
  private Long warehousingNumber;
  /** 入库明细*/
  private Long detail;


  /** 进货单*/
  private Purchase purchase;
  /** 进货详细单*/
  private DetailedPurchase detailedPurchase;
  /** 审核人*/
  private User examineUser;
  /** 入库人*/
  private User warehousingUser;
  /** 商品sku*/
  private  Goodsku goodsku;
  /** 商品spu*/
  private  Goodspu goodspu;



  private Long createUserId;
  private Date createTime;
  private Long userRenewId;
  private Date renewTime;
}
