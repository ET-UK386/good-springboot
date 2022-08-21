package com.zb.service;

import com.zb.pojo.ImagesFk;
import com.zb.pojo.ImagesPath;

import java.io.File;

public interface UploadImagesService {

    String[] selectBySkuIdToUrl(Long id);

    String uploadImage(File f, Long skuId, String name);
}
