package com.bin23.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.FORBIDDEN,reason="你想访问我？不可能")
public class MyException extends Exception {

}
