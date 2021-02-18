package com.bin23.controller;

import com.bin23.entity.UserInfo;
import com.bin23.service.UserInfoService;
import com.bin23.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("ssmController")
public class SSMController {

    @Autowired
    @Qualifier("userInfoService")
    private UserInfoService userInfoService;


    @RequestMapping("register")
    public String register(UserInfo userInfo, Model model){
        int register = userInfoService.register(userInfo);
        model.addAttribute("count",register);
        return "success";
    }
}
