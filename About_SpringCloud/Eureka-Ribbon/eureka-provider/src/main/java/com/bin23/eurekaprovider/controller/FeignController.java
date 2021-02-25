package com.bin23.eurekaprovider.controller;

import com.bin23.eurekaprovider.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeignController {

    @GetMapping("/hello1")
    public String sayHelloToFeign(@RequestParam String name){
        return "哈喽，Feign" + name;
    }

    @GetMapping("/hello2")
    public User sayHelloToFeign(@RequestParam String name, @RequestHeader Integer age){
        return new User(name, age);
    }

    @PostMapping("/hello3")
    public String sayHelloToFeign(@RequestBody User user){
        return "哈喽，Feign" + user.getName() + "," + user.getAge();
    }
}
