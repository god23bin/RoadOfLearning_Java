package com.bin23.eurekaprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortController {
    @Value("${server.port}")
    String port;
    @RequestMapping("port")
    public String getPort(){
        return "哈喽！，我来自的端口号是" + port;
    }
}
