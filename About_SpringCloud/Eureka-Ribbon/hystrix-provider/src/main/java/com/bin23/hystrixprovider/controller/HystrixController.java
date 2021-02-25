package com.bin23.hystrixprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {

    @RequestMapping("/hi")
    public String hi(String id){
        return "你好啊世界，我来自Hystrix！，id = " + id;
    }
}
