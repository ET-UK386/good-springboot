package com.zb.controller;

import com.zb.service.UploadImagesService;
import com.zb.utils.Result;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("uploadImg")
public class UploadImagesController {

    @Autowired
    private UploadImagesService uploadImagesService;

    @GetMapping("findBySkuId/{skuId}")
    public String[] findBySkuId(@PathVariable("skuId") Long skuId){
        String[] strings = uploadImagesService.selectBySkuIdToUrl(skuId);
        return strings;
    }

    /**
     * 上传图片
     * @param file
     * @param skuId
     * @param name
     * @return
     */
    @PostMapping("add")
    @CrossOrigin("*")
    public Result add(MultipartFile file, Long skuId, String name){
        Result r = new Result();
        if (Objects.isNull(file)) {
            return r.setMessage("文件为空").setCode(500);
        }
        // 获取文件名称
        String filename = file.getOriginalFilename();
        // 获取文件后缀 带.
        String suffix = filename.substring(filename.lastIndexOf('.'));

        String url = null;
        try {
            // 用MultipartFile 封装成File
            File f = File.createTempFile(filename, suffix);
            file.transferTo(f);

            System.out.println(f);

            url = uploadImagesService.uploadImage(f,skuId, name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(Strings.isEmpty(url)){
            r.setCode(404).setMessage("error");
        }else{
            r.setCode(200).setData(url).setMessage("success");
        }

        return r;
    }

}
