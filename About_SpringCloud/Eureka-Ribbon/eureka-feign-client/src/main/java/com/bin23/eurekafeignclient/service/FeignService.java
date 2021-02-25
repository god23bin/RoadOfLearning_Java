package com.bin23.eurekafeignclient.service;

import com.bin23.eurekafeignclient.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name = "eureka-provider")
public interface FeignService {

    @GetMapping("/hello")
    String sayHelloToFeign();

    @GetMapping("/hello1")
    public String sayHelloToFeign(@RequestParam String name);

    @GetMapping("/hello2")
    public User sayHelloToFeign(@RequestParam String name, @RequestHeader("age") Integer age);

    @PostMapping("/hello3")
    public String sayHelloToFeign(@RequestBody User user);
}
