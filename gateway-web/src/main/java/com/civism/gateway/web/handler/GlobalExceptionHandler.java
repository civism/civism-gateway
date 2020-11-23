package com.civism.gateway.web.handler;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.civism.gateway.common.Result;
import com.civism.gateway.exception.GatewayException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/11/23 17:49
 * @E-mail:695234456@qq.com
 * @return
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(GatewayException.class)
    public Result<Void> handlerException(GatewayException gatewayException) {
        log.error("gateway exception {} ######  {}", ExceptionUtil.getMessage(gatewayException), ExceptionUtil.stacktraceToString(gatewayException));
        return Result.fail(gatewayException.getErrorCode(), gatewayException.getErrorMsg());
    }


    @ExceptionHandler(Exception.class)
    public Result<Void> handlerException(Exception exception) {
        String message = ExceptionUtil.getMessage(exception);
        return Result.fail("10001", message);
    }
}
