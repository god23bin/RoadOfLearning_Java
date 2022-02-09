package com.god23bin.commonbase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 配置
 * @author god23bin
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // 配置Swagger的Docket的bean实例
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(webApiInfo());
    }

    private ApiInfo webApiInfo() {
        // 作者信息（合同）
        Contact contact = new Contact("god23bin", "https://god23bin.cn", "god23bin@qq.com");
        return new ApiInfoBuilder()
                .title("god23bin的SwaggerAPI文档")
                .description("本文档描述了跨平台云存储系统的接口定义")
                .version("1.0")
                .termsOfServiceUrl("https://god23bin.cn")
                .contact(contact)
                .build();
    }
}
