package com.zb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Accessors(chain = true)
public class Warehousing {

  private Long id;
  /** 进货单ID*/
  private Long purchaseId;
  /** 进货详细单ID*/
  private Long detailedPurchaseId;
  /** 审核人ID*/
  private Long examineUserId;
  /** 审核时间*/
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "UTC+8")
  private Date examineTime;
  /** 入库人*/
  private Long warehousingUserId;
  /** 入库时间*/
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "UTC+8")
  private Date warehousingTime;
  /** 入库数量*/
  private Integer warehousingNumber;
  /** 入库明细
   * 0：待审核（签收审核）
   * 1：待审核不通过（订单作废）
   * 2：审核数目不对（签收审核）
   * 3：待入库（入库盛和）
   * 4：待入库不通过（订单作废）
   * 5：入库数目不对（入库盛和）
   * 200：
   * */
  private Integer status;
  /** 签收明细*/
  private String signingDetails;
  /** 入库明细*/
  private String inventoryDetails;
  private String statusStr;


  /** 进货单*/
  private Purchase purchase;
  /** 进货详细单*/
  private DetailedPurchase detailedPurchase;
  /** 审核人*/
  private User examineUser;
  /** 入库人*/
  private User warehousingUser;
  /** 商品sku*/
  private Goodsku goodsku;
  /** 商品spu*/
  private Goodspu goodspu;
  private String token;



  private Long createUserId;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "UTC+8")
  private Date createTime;
  private Long userRenewId;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "UTC+8")
  private Date renewTime;

  public String getStatusStr() {
    switch (this.status){
      case 0:
        this.statusStr = "待审核";
        break;
      case 1:
        this.statusStr = "待审核不通过";
        break;
      case 2:
        this.statusStr = "审核数目不对";
        break;
      case 3:
        this.statusStr = "待入库";
        break;
      case 4:
        this.statusStr = "待入库不通过";
        break;
      case 5:
        this.statusStr = "入库数目不对";
        break;
      case 6:
        this.statusStr = "有问题";
        break;
      case 200:
        this.statusStr = "完成";
        break;
      default:
        break;
    }
    return statusStr;
  }
}
