package com.god23bin.vod.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取配置文件固定值
 * @author god23bin
 */
@Component
@ConfigurationProperties(prefix = "aliyun.vod.file")
@Data
public class UtilOfVod {
    private String accessKeyId;
    private String accessKeySecret;
}
