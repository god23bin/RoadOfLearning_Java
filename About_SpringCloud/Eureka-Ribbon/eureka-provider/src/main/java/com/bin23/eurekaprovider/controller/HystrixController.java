package com.bin23.eurekaprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {

    @RequestMapping("/")
    public String hi(String id){
        return "嗨！，成功用HystrixController访问" + id;
    }
}
