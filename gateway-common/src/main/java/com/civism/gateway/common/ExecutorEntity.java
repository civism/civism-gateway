package com.civism.gateway.common;

import lombok.Data;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/11/20 15:02
 * @E-mail:695234456@qq.com
 * @return
 */
@Data
public class ExecutorEntity {

    /**
     * 接口名
     */
    private String interfaceName;

    /**
     * 方法名称
     */
    private String method;

    /**
     * 版本号
     */
    private String version;

    /**
     * 参数类型
     */
    private String[] parameterTypes;

    /**
     * 参数值
     */
    private Object[] args;
}
