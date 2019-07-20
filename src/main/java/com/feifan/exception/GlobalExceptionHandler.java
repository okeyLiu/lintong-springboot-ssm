package com.feifan.exception;

import com.feifan.common.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        System.out.println("\n\nException-->" + e.getMessage());
        return new Result(false, e.getMessage());
    }

}
