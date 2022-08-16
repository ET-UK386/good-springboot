package com.zb.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 经销商
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Vendor {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 供应商名称
     */
    private String vendorName;
    /**
     * 商品skuid
     */
    private Integer skuId;
    /**
     * 厂商址
     */
    private String vendorAddress;
    /**
     * 描述信息
     */
    private String desc;
    /**
     * 负责人
     */
    private String principal;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 创建人id
     */
    private Integer createUserId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人id
     */
    private Integer userRenewId;
    /**
     * 更新时间
     */
    private Date renewTime;

}
