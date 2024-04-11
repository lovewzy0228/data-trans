package com.psbc.data.trans.configuration.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhenyu.wu
 * @date 2024/4/11 17:03
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<Void> handleException(Exception e) {
        return Result.fail(e);
    }
}
