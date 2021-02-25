package com.bin23.eurekahystrixclient.controller;

import com.bin23.eurekahystrixclient.service.LocalItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalItemController {

    @Autowired
    private LocalItemService localItemService;

    @GetMapping("/hi")
    public String hi(String id){
        return localItemService.hi(id);
    }
}
