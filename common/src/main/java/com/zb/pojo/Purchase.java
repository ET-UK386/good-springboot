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
}
