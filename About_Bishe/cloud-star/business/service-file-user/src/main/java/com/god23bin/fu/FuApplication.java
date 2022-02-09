package com.god23bin.fu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author god23bin
 */
@SpringBootApplication
@MapperScan("com.god23bin.fu.mapper")
@ComponentScan(basePackages={"com.god23bin"})
public class FuApplication {
    public static void main(String[] args) {
        SpringApplication.run(FuApplication.class, args);
    }
}
