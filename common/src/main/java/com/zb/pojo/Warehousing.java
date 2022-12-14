package com.zb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * 入库流程
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Warehousing {

    private Long id;
    /**
     * 进货单ID
     */
    private Long purchaseId;
    /**
     * 进货详细单ID
     */
    private Long detailedPurchaseId;
    /**
     * 审核人ID
     */
    private Long examineUserId;
    /**
     * 审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "UTC+8")
    private Date examineTime;
    /**
     * 入库人
     */
    private Long warehousingUserId;
    /**
     * 入库时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "UTC+8")
    private Date warehousingTime;
    /**
     * 入库数量
     */
    private Integer warehousingNumber;
    /**
     * 入库明细
     * 0：待审核（签收审核）
     * 1：待审核不通过（订单作废）
     * 2：审核数目不对（签收审核）
     * 3：待入库（入库盛和）
     * 4：待入库不通过（订单作废）
     * 5：入库数目不对（入库盛和）
     * 200：
     */
    private Integer status;
    /**
     * 签收明细
     */
    private String signingDetails;
    /**
     * 入库明细
     */
    private String inventoryDetails;
    private String statusStr;


    private Long createUserId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC+8")
    private Date createTime;
    private Long userRenewId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC+8")
    private Date renewTime;


    /**
     * 进货单
     */
    private Purchase purchase;
    /**
     * 进货详细单
     */
    private DetailedPurchase detailedPurchase;
    /**
     * 审核人
     */
    private User examineUser;
    /**
     * 入库人
     */
    private User warehousingUser;
    /**
     * 商品sku
     */
    private Goodsku goodsku;
    /**
     * 商品spu
     */
    private Goodspu goodspu;
    private String token;
    private List<DetailedWarehousing> detailedWarehousingList;

    public String getStatusStr() {
        switch (this.status) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Long getDetailedPurchaseId() {
        return detailedPurchaseId;
    }

    public void setDetailedPurchaseId(Long detailedPurchaseId) {
        this.detailedPurchaseId = detailedPurchaseId;
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

    public Long getWarehousingUserId() {
        return warehousingUserId;
    }

    public void setWarehousingUserId(Long warehousingUserId) {
        this.warehousingUserId = warehousingUserId;
    }

    public Date getWarehousingTime() {
        return warehousingTime;
    }

    public void setWarehousingTime(Date warehousingTime) {
        this.warehousingTime = warehousingTime;
    }

    public Integer getWarehousingNumber() {
        return warehousingNumber;
    }

    public void setWarehousingNumber(Integer warehousingNumber) {
        this.warehousingNumber = warehousingNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSigningDetails() {
        return signingDetails;
    }

    public void setSigningDetails(String signingDetails) {
        this.signingDetails = signingDetails;
    }

    public String getInventoryDetails() {
        return inventoryDetails;
    }

    public void setInventoryDetails(String inventoryDetails) {
        this.inventoryDetails = inventoryDetails;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
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

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public DetailedPurchase getDetailedPurchase() {
        return detailedPurchase;
    }

    public void setDetailedPurchase(DetailedPurchase detailedPurchase) {
        this.detailedPurchase = detailedPurchase;
    }

    public User getExamineUser() {
        return examineUser;
    }

    public void setExamineUser(User examineUser) {
        this.examineUser = examineUser;
    }

    public User getWarehousingUser() {
        return warehousingUser;
    }

    public void setWarehousingUser(User warehousingUser) {
        this.warehousingUser = warehousingUser;
    }

    public Goodsku getGoodsku() {
        return goodsku;
    }

    public void setGoodsku(Goodsku goodsku) {
        this.goodsku = goodsku;
    }

    public Goodspu getGoodspu() {
        return goodspu;
    }

    public void setGoodspu(Goodspu goodspu) {
        this.goodspu = goodspu;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<DetailedWarehousing> getDetailedWarehousingList() {
        return detailedWarehousingList;
    }

    public void setDetailedWarehousingList(List<DetailedWarehousing> detailedWarehousingList) {
        this.detailedWarehousingList = detailedWarehousingList;
    }
}
