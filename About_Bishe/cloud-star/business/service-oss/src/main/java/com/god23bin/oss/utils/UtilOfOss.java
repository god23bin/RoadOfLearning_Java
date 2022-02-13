package com.god23bin.oss.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取配置文件固定值
 * @author god23bin
 */
@Component
@ConfigurationProperties(prefix = "aliyun.oss.file")
@Data
public class UtilOfOss {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String fileHost;
    private String bucketName;

//    public static String END_POINT;
//    public static String ACCESSKEY_ID;
//    public static String ACCESSKEY_SECRET;
//    public static String BUCKET_NAME;
//    public static String FILE_HOST;

}
