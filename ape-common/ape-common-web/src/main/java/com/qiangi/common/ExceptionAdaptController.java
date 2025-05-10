package com.qiangi.common;


import com.qiangi.bean.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 进行全局异常统一处理
 */
@RestControllerAdvice
public class ExceptionAdaptController {


    @ExceptionHandler(value = RuntimeException.class)
    public Result runTimeException(RuntimeException exception) {
        exception.printStackTrace();
        return Result.fail(exception.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception exception) {
        exception.printStackTrace();
        return Result.fail(exception.getMessage());
    }
}
