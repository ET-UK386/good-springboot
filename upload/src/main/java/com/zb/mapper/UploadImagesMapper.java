package com.zb.mapper;

import com.zb.pojo.ImagesFk;
import com.zb.pojo.ImagesPath;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UploadImagesMapper {

    List<ImagesFk> selectById(Long id);

    Integer insertImagesFK(ImagesFk imagesFk);

    Integer insertImagesPath(ImagesPath imagesPath);

}
