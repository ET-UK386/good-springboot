package com.zb.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 权限表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Power {

  private Long id;
  /** 用户ID*/
  private Long roleId;
  /** 是否可看*/
  private Integer isLook;
  /** 是否可操作*/
  private Integer isUse;

  private Long createUserId;
  private Date createTime;
  private Long userRenewId;
  private Date renewTime;


}
