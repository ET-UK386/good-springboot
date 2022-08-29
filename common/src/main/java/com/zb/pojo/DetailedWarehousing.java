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
public class DetailedWarehousing {

    private Long id;
    /** 入库流程ID*/
    private Long warehousingId;
    /** 供应商ID*/
    private Long vendorId;
    /**商品skuid*/
    private Long skuId;
    /** 批次*/
    private String batch;
    /** 购买价格*/
    private BigDecimal purchasePrice;
    /** 数量*/
    private Integer number;
    /** 状态*/
    private Integer status;
    /** 逻辑删除*/
    private Integer logicDel;


    /**创建人id*/
    private Long createUserId;
    /**创建时间*/
    private Date createTime;
    /**更新人id*/
    private Long userRenewId;
    /**更新时间*/
    private Date renewTime;

    /**入库流程单*/
    private Warehousing warehousing;
    /**经销商*/
    private Vendor vendor;
    /**商品sku*/
    private Goodsku goodsku;
    /**创建人*/
    private User createUser;
    /**更新人*/
    private User userRenew;

    public String getStatusStr(){
        Integer status = this.getStatus();
        switch (status) {
            case 0:
                return "审核中";
            case 1:
                return "同意";
            case 2:
                return "驳回";
            case 3:
                return "供应商没货";
            default:
                return null;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWarehousingId() {
        return warehousingId;
    }

    public void setWarehousingId(Long warehousingId) {
        this.warehousingId = warehousingId;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLogicDel() {
        return logicDel;
    }

    public void setLogicDel(Integer logicDel) {
        this.logicDel = logicDel;
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

    public Warehousing getWarehousing() {
        return warehousing;
    }

    public void setWarehousing(Warehousing warehousing) {
        this.warehousing = warehousing;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Goodsku getGoodsku() {
        return goodsku;
    }

    public void setGoodsku(Goodsku goodsku) {
        this.goodsku = goodsku;
    }

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public User getUserRenew() {
        return userRenew;
    }

    public void setUserRenew(User userRenew) {
        this.userRenew = userRenew;
    }
}
