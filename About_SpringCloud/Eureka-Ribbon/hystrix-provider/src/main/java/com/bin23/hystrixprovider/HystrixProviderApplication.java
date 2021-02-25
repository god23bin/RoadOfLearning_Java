package com.bin23.hystrixprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HystrixProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixProviderApplication.class, args);
    }

}
