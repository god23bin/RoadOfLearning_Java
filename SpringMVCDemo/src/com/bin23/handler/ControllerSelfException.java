package com.bin23.handler;

import com.bin23.exception.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ControllerSelfException {

    @RequestMapping("testMyException/{i}")
    public String testMyException(@PathVariable("i") Integer i) throws MyException {
        if(i == 3) {
            throw new MyException();//抛出异常
        }
        return "success" ;
    }

    @ResponseStatus(value= HttpStatus.CONFLICT  ,reason="测试，标注在方法上")
    @RequestMapping("testResponseStatus")
    public String testResponseStatus() {
        return "success" ;
    }
}
