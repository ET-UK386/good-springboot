package com.zb.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ImagesFk {

  private Long id;
  private Long skuId;
  private Long spuId;
  private Long imagesPathId;
  private Integer isLook;

  private ImagesPath imagesPath;

}
