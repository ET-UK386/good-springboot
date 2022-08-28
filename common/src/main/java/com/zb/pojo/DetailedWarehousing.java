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
}
