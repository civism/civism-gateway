package com.civism.gateway.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/11/20 15:15
 * @E-mail:695234456@qq.com
 * @return
 */
@Getter
@Setter
public class GatewayException extends RuntimeException {
    private static final long serialVersionUID = -7193248179774358101L;


    private String errorCode;

    private String errorMsg;


    public GatewayException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.errorMsg = message;
    }
}
