package com.bin23.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Value("${foo}")
    private String foo;

    @RequestMapping("/foo")
    public String hi(){
        return foo;
    }
}
