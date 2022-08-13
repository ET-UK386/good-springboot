package com.zb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author 1541
 * 库存盘点表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class InventoryVerification {

  private Long id;
  /** 仓库id*/
  private Long warehouseId;
  /** 盘点人ID*/
  private Long checkUserId;
  /** 盘点时间*/
  private Date checkTime;
  /** 状态  0：未盘点 1：已盘点 */
  private Integer status;
  /** 描述*/
  private String desc;
  /** 盘点差异  多或少*/
  private Integer discrepancy;

  private Long createUserId;
  private Date createTime;
  private Long userRenewId;
  private Date renewTime;
}
