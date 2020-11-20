package com.civism.gateway.web.controller;

import com.civism.gateway.common.Result;
import com.civism.gateway.common.SystemParamDTO;
import com.civism.gateway.core.factory.DubboFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/8/8 11:25
 */
@RestController
public class IndexController {


    @PostMapping("/index")
    public Result<Object> index(@RequestBody SystemParamDTO systemParam) {
        DubboFactory dubboFactory = new DubboFactory("civism-gateway", "127.0.0.1:2181", "zookeeper");

        return null;
    }
}
