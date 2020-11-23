package com.civism.gateway.spring;

import com.civism.gateway.common.ExecutorEntity;
import com.civism.gateway.core.factory.DubboFactory;
import com.civism.gateway.interfaces.ExecutorFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/11/20 14:51
 * @E-mail:695234456@qq.com
 * @return
 */
@Service
public class DubboSpringFactory implements ExecutorFactory {

    @Value("${dubbo.application.name}")
    private String applicationName;

    @Value("${dubbo.registry.address}")
    private String address;

    @Value("${dubbo.registry.protocol}")
    private String protocol;

    private static DubboFactory dubboFactory;

    public DubboFactory getInit() {
        return new DubboFactory(applicationName, address, protocol);
    }

    @Override
    public Object executor(ExecutorEntity executorEntity) {
        if (dubboFactory == null) {
            synchronized (this) {
                if (dubboFactory == null) {
                    dubboFactory = getInit();
                }
            }
        }
        return dubboFactory.call(executorEntity.getInterfaceName(), executorEntity.getMethod(), executorEntity.getVersion(), executorEntity.getParameterTypes(), executorEntity.getArgs());
    }
}
