package com.civism.gateway.exception;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/11/20 15:15
 * @E-mail:695234456@qq.com
 * @return
 */
public class GatewayException extends RuntimeException {
    private static final long serialVersionUID = -7193248179774358101L;

    public GatewayException(String message) {
        super(message);
    }
}
