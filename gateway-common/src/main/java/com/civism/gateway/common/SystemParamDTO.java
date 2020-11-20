package com.civism.gateway.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/8/8 11:30
 * @E-mail:695234456@qq.com
 * @return
 */
@Data
public class SystemParamDTO implements Serializable {
    private static final long serialVersionUID = 8129705037673018553L;

    /**
     * 业务方appId
     */
    private String appId;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 默认：1.0
     */
    private String version;

    /**
     * 默认：UTF-8
     */
    private String charset;

    /**
     * 签名类型：RSA或RSA2
     */
    private String signType;

    /**
     * 签名
     */
    private String sign;

    /**
     * 业务内容 ：json 格式字符串
     */
    private String content;

    /**
     * 协议
     */
    private String protocol;


}
