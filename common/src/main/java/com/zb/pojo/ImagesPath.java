package com.zb.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ImagesPath {

  private Long id;
  private String imagesName;
  private String path;
  private Integer isLook;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getImagesName() {
    return imagesName;
  }

  public void setImagesName(String imagesName) {
    this.imagesName = imagesName;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Integer getIsLook() {
    return isLook;
  }

  public void setIsLook(Integer isLook) {
    this.isLook = isLook;
  }
}
