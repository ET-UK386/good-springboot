package com.zb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class GoodskuWarehouse {


	        private Long gid;
            private Long wid;
            private Long detailedWarehousingId;
            private String skuName;
            private String skuDesc;
            private Long colorId;
            private Long priceId;
            private Long spuId;
            private Long stockId;
            private String salesVolume;
            private Long companyId;
            private String manufacturer;
            private Long supplierId;
            private Integer logicStatus;
            private Integer stockNumber;
            private String warehouseAddress;
            private String phone;
            private Long skuId;
            private String batch;

            private BigDecimal price;
}
