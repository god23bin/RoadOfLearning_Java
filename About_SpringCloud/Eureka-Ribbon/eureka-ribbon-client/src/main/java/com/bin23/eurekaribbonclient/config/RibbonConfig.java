package com.bin23.eurekaribbonclient.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfig {
    /**
     * @Bean注入返回的RestTemplate对象到IOC容器
     * @LoadBalanced使RestTemplate具备负载均衡的能力
     * @param builder
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
