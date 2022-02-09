package com.god23bin.commonbase.exception;

import com.god23bin.commonutils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * @author god23bin
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 通过@ExceptionHandler指定出现何种异常时执行该方法
     * 全局异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody // 为了返回数据
    public Result allError(Exception e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return Result.error().msg("执行了全局异常处理..");
    }

    /**
     * 算术异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result arithmeticError(ArithmeticException e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return Result.error().msg("执行了算术异常处理..");
    }

    /**
     * 自定义异常测试
     * @param e
     * @return
     */
    @ExceptionHandler(DiyException.class)
    @ResponseBody
    public Result diyError(DiyException e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return Result.error().code(e.getCode()).msg(e.getMsg());
    }
//    对于自定义的异常
//    后续需要的话，得自己抛出这个异常
//    try {
//
//    } catch() {
//        throw new DiyException(2023, "抛出自定义异常");
//    }
}
