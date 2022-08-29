package com.zb.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
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
    /**进货描述*/
    private String purchaseDesc;
    /**采购数量*/
    private Integer purchaseNumber;
    /**审核人ID*/
    private Long examineUserId;
    /**审核人时间*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date examineTime;
    /**审核人建议*/
    private String examineOpinion;
    /**流程状态状态    0：审核中，1：审核完成， 2：审核不通过，3：审核驳回需要修改,4:订单完成*/
    private Integer examineStatus;
    /**总价*/
    private BigDecimal sumPrice;
    /** 逻辑删除*/
    private Integer logicDel;

    private Long createUserId;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    private Long userRenewId;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date renewTime;

    private User examineUser;
    private User createUser;
    private User userRenew;
    private String token;

    public String getExamineStatusStr(){
        Integer examineStatus = this.getExamineStatus();
        switch (examineStatus){
            case 0:
                return "审核中";
            case 1:
                return "审核完成";
            case 2:
                return "审核不通过";
            case 3:
                return "审核驳回";
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

    public String getPurchaseDesc() {
        return purchaseDesc;
    }

    public void setPurchaseDesc(String purchaseDesc) {
        this.purchaseDesc = purchaseDesc;
    }

    public Integer getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(Integer purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public Long getExamineUserId() {
        return examineUserId;
    }

    public void setExamineUserId(Long examineUserId) {
        this.examineUserId = examineUserId;
    }

    public Date getExamineTime() {
        return examineTime;
    }

    public void setExamineTime(Date examineTime) {
        this.examineTime = examineTime;
    }

    public String getExamineOpinion() {
        return examineOpinion;
    }

    public void setExamineOpinion(String examineOpinion) {
        this.examineOpinion = examineOpinion;
    }

    public Integer getExamineStatus() {
        return examineStatus;
    }

    public void setExamineStatus(Integer examineStatus) {
        this.examineStatus = examineStatus;
    }

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice;
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

    public User getExamineUser() {
        return examineUser;
    }

    public void setExamineUser(User examineUser) {
        this.examineUser = examineUser;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
