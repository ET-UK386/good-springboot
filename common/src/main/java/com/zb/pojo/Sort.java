package com.zb.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 分类表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Sort {

  private Long id;
  /** 分类名称*/
  private String sortName;
  /** 所属上级分类ID*/
  private Long parentId;
  /** 属于什么模块（生活用品，智能家电）*/
  private String module;
  private Long createUserId;
  private Date createTime;
  private Long userRenewId;
  private Date renewTime;
}
