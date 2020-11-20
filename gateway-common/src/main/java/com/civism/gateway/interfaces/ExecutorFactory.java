package com.civism.gateway.interfaces;

import com.civism.gateway.common.ExecutorEntity;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/11/20 11:35
 * @E-mail:695234456@qq.com
 * @return
 */
public interface ExecutorFactory {

    Object executor(ExecutorEntity executorEntity);
}
