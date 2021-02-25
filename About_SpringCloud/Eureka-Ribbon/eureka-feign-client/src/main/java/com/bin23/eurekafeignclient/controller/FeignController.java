package com.bin23.eurekafeignclient.controller;

import com.bin23.eurekafeignclient.entity.User;
import com.bin23.eurekafeignclient.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @GetMapping("/hello")
    public String hello(){

        return feignService.sayHelloToFeign();
    }

    @GetMapping("/helloUser")
    public String helloUser(){
        StringBuilder sb = new StringBuilder();
        sb.append(feignService.sayHelloToFeign("蔡徐坤")).append("<br/>");
        sb.append(feignService.sayHelloToFeign(new User("勒布朗", 35))).append("<br/>");
        sb.append(feignService.sayHelloToFeign("科比", 41)).append("<br/>");
        return sb.toString();
    }
}
