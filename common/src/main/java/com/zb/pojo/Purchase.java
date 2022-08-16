package com.zb.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 进货单
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Purchase {

  private Long id;
  /** 进货描述*/
  private String purchaseDesc;
    /** 采购数量*/
  private Long purchaseNumber;
    /** 审核人ID*/
  private Long examineUserId;
    /** 审核人时间*/
  private Date examineTime;
    /** 审核人建议*/
  private String examineOpinion;
    /** 流程状态状态    0：审核中，1：审核完成， 2：审核不通过，3：审核驳回需要修改*/
  private Long status;

  /** 审核人*/
  private User examineUser;



  private Long createUserId;
  private Date createTime;
  private Long userRenewId;
  private Date renewTime;


    /**
     * 价格表
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class Price {

      private Integer id;
      /** sku ID*/
      private Integer skuId;
      /** 价格*/
      private BigDecimal price;

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

      public Integer getSkuId() {
        return skuId;
      }

      public void setSkuId(Integer skuId) {
        this.skuId = skuId;
      }

      public BigDecimal getPrice() {
        return price;
      }

      public void setPrice(BigDecimal price) {
        this.price = price;
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
}
