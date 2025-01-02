package com.seecen.springboot_backendmanagement.exception;

import com.seecen.springboot_backendmanagement.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author aql
 * @Date 2024/12/9 上午11:33
 * @Version 1.0
 **/
//@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    Logger logger =  LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception e){
        logger.error("全局异常处理", e);
        return Result.error(e.getMessage());
    }
}
