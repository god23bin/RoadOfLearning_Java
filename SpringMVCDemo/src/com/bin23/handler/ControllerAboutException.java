package com.bin23.handler;

import com.bin23.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerAboutException {
    @RequestMapping("testExceptionHandler")
    public String testExceptionHandler() {
        //正常来说这里直接来try catch，但现在可以通过@ExceptionHandler来捕获异常
//		try {
            System.out.println( 1/0 );//
//		}catch(ArithmeticException e) e
//		}catch(Exception e) e

        return "success" ;
    }

    @RequestMapping("testExceptionHandler2")
    public String testExceptionHandler2() {
        int[] nums = new int[2];
        System.out.println(nums[2]);//ArrayIndexOutOfBoundsException
        return "success" ;
    }

    //使用@ExceptionHandler注解的该方法可以捕获  本类中  抛出的ArithmeticException异常
    @ExceptionHandler({ArithmeticException.class,ArrayIndexOutOfBoundsException.class  })
    public String handlerArithmeticException(Exception e, Model m) {
        System.out.println(e +"============");
        e.printStackTrace();
        String message = e.getMessage();
        m.addAttribute("e",e);
        m.addAttribute("message",message);
        return "error" ;
    }

}
