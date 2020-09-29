package com.civism.gateway.core.service.impl;

import com.civism.gateway.core.entity.SystemParamDTO;
import com.civism.gateway.core.factory.DubboFactory;
import com.civism.gateway.core.service.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/8/10 14:54
 */
@Service
public class DubboServiceImpl implements DubboService {

    @Resource
    private DubboFactory dubboFactory;

    @Override
    public Object callBack(SystemParamDTO systemParamDTO) {
        Object sayHello = dubboFactory.call("com.example.demo.service.HelloService", "sayHello", null, new String[]{}, new Object[]{});
        System.out.println(sayHello);
        return sayHello;
    }

    @Override
    public void callBack() {

    }
}
