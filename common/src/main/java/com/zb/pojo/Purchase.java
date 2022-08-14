package com.zb.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
    /**
     * 进货描述
     */
    private String purchaseDesc;
    /**
     * 采购数量
     */
    private Long purchaseNumber;
    /**
     * 审核人ID
     */
    private Long examineUserId;
    /**
     * 审核人时间
     */
    private Date examineTime;
    /**
     * 审核人建议
     */
    private String examineOpinion;
    /**
     * 流程状态状态    0：审核中，1：审核完成， 2：审核不通过，3：审核驳回需要修改
     */
    private Long status;
    /**
     * 创建人
     */
    private Long createUserId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人
     */
    private Long userRenewId;
    /**
     * 更新时间
     */
    private Date renewTime;

    /**
     * 审核人
     */
    private User examineUser;
    /**
     * 创建人
     */
    private User createUser;
    /**
     * 更新人
     */
    private User userRenew;

}
