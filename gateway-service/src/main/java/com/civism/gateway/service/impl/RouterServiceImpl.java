package com.civism.gateway.service.impl;

import com.civism.gateway.common.SystemParamDTO;
import com.civism.gateway.interfaces.ExecutorFactory;
import com.civism.gateway.service.RouterService;
import com.civism.gateway.service.factory.GatewayFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/11/20 11:02
 * @E-mail:695234456@qq.com
 * @return
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RouterServiceImpl implements RouterService {


    private final GatewayFactory gatewayFactory;


    @Override
    public Object route(SystemParamDTO systemParam) {
        ExecutorFactory executorProtocol = gatewayFactory.getExecutorProtocol(systemParam.getProtocol());
        return executorProtocol.executor(null);
    }
}
