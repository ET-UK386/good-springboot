package com.zb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SalesDetails implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 订单编号
     */
    private String batchNumber;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 总价
     */
    private Double price;
    /**
     * 关联sku  供应商生产商都在里面关联着
     */
    private Integer skuId;
    /**
     * 创建人
     */
    private Integer creatorId;
    /**
     * 创建时间
     */
    private Date creatorTime;
    /**
     * 状态，0：未支付，1：未收货（运送途中），2：签收成功
     */
    private String state;
    /**
     * 付款时间
     */
    private Date payTime;
    /**
     * 发货时间
     */
    private Date shipmentsTime;
    /**
     * 成交时间
     */
    private Date finishTime;


    /**
     * 关联sku
     */
    private Goodsku goodsku;

    /**
     * 供应商
     */
    private Vendor vendor;

}

