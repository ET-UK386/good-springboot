package com.zb.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.IOException;

/**
 * @author AggerChen
 * @ClassName: OSSConfig
 * @Description: OSS配置类
 * @date 2016年11月4日 下午3:58:36
 */
@Data
@Accessors(chain = true)
class OSSConfig {
    /** 连接区域地址*/
    private String endpoint;
    /** 连接keyId*/
    private String accessKeyId;
    /** 连接秘钥*/
    private String accessKeySecret;
    /** 需要存储的bucketName*/
    private String bucketName;
    /** 图片保存路径*/
    private String picLocation;

    public OSSConfig() {
        try {
            this.endpoint = SystemConfig.getConfigResource("endpoint");
            this.bucketName = SystemConfig.getConfigResource("bucketName");
            this.picLocation = SystemConfig.getConfigResource("picLocation");
            this.accessKeyId = SystemConfig.getConfigResource("accessKeyId");
            this.accessKeySecret = SystemConfig.getConfigResource("accessKeySecret");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}