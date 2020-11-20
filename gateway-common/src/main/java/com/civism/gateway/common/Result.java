package com.civism.gateway.common;

import lombok.Data;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/11/20 10:24
 * @E-mail:695234456@qq.com
 * @return
 */
@Data
public class Result<T> {

    private boolean success;

    private T data;

    private String errorCode;

    private String errorMsg;

    public Result(boolean success, T data, String errorCode, String errorMsg) {
        this.success = success;
        this.data = data;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public static <T> Result<T> success(T data) {
        return new Result<T>(true, data, null, null);
    }

    public static <T> Result<T> fail(String errorCode, String errorMsg) {
        return new Result<>(false, null, null, null);
    }
}
