package com.bin23.eurekaribbonclient.controller;

import com.bin23.eurekaribbonclient.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {

    @Autowired
    RibbonService ribbonService;

    @RequestMapping("/hi")
    public String hi(){
        return ribbonService.hi();
    }
}
