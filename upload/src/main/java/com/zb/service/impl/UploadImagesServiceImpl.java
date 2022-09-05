package com.zb.service.impl;

import com.zb.mapper.UploadImagesMapper;
import com.zb.pojo.ImagesFk;
import com.zb.pojo.ImagesPath;
import com.zb.service.UploadImagesService;
import com.zb.utils.OSSUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UploadImagesServiceImpl implements UploadImagesService {

    @Autowired
    private UploadImagesMapper uploadImagesMapper;

    @Override
    public List<String> selectBySkuIdToUrl(Long id) {
        List<ImagesFk> imagesFks = uploadImagesMapper.selectById(id);
        List<String> urls = new ArrayList<>();
        for (ImagesFk imagesFk : imagesFks) {
            urls.add(imagesFk.getImagesPath().getPath());
        }
        return urls;
    }

    @Override
    public String uploadImage(File file, Long skuId, String name) {

        String fileName = file.getName();
        // 获取文件后缀 不带.
        String suffix = fileName.substring(fileName.lastIndexOf('.') + 1);
        // 上传到阿里云OSS
        String s = OSSUploadUtil.uploadFile(file, suffix);

        // 封装数据
        ImagesPath imagesPath = new ImagesPath();
        imagesPath.setPath(s);

        imagesPath.setImagesName(name);
        ImagesFk imagesFk = new ImagesFk().setSkuId(skuId);

        // 保存到数据库
        Integer p = uploadImagesMapper.insertImagesPath(imagesPath);
        imagesFk.setImagesPathId(imagesPath.getId());
        Integer f = uploadImagesMapper.insertImagesFK(imagesFk);

        if (p < 1) {
            if( f < 1){
                s = null;
            }
            s = null;
        }
        return s;
    }
}
