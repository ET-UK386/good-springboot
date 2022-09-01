package com.zb.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class InSellingGoods {

  private Long prId;
  private Long prSkuId;
  private Integer prNumber;
  private Integer prStatus;
  private Long prPriceId;
  private Long prUserId;
  private Long pId;
  private Long pSkuId;
  private BigDecimal pPrice;
  private Long skuId;
  private Long skuSpuId;
  private String skuSkuName;
  private String skuSkuDesc;
  private Long skuColorId;
  private Long skuPriceId;
  private Long skuStockId;
  private Integer skuSalesVolume;
  private Long skuCompanyId;
  private String skuManufacturer;
  private Long skuSupplierId;
  private Long ifkId;
  private Long ifkSkuId;
  private Long ifkSpuId;
  private Long ifkImagesPathId;
  private Integer ifkIsLook;
  private String ipImagesName;
  private String ipPath;
  private Integer ipIsLook;
  private Long ipId;

}
