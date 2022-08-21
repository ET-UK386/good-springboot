package com.zb.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 角色表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

  private Long id;
  /** 角色名称*/
  private String roleName;
  private String userPower;
  /** 所属上级*/
  private Long parentId;

  private Long createUserId;
  private Date createTime;
  private Long userRenewId;
  private Date renewTime;

}
