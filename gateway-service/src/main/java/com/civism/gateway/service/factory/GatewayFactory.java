package com.civism.gateway.service.factory;

import com.civism.gateway.interfaces.ExecutorFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/11/20 11:20
 * @E-mail:695234456@qq.com
 * @return
 */
@Service
public class GatewayFactory {

    private final ConcurrentHashMap<String, ExecutorFactory> gateWayMap = new ConcurrentHashMap<>(4);



    public ExecutorFactory getExecutorProtocol(String protocol) {
        ExecutorFactory dubboFactory = gateWayMap.get(protocol);

        return gateWayMap.get(protocol);
    }

}
