package com.zb.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Goodspu {

    private Long id;
    private String goodName;
    private String brand;
    private Long sortId;
    private Integer status;
    private Long createUserId;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    private Long userRenewId;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date renewTime;
    private Long colorId;
    private Long priceId;
    private Long companyId;
    private String con3;
    private Sort sort;
    private Color color;
    private Units units;
    private User user;
    private Price price;


}
