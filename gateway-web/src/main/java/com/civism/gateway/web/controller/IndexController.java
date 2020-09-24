package com.civism.gateway.web.controller;

import com.civism.gateway.core.entity.SystemParamDTO;
import com.civism.gateway.core.factory.DubboFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/8/8 11:25
 * @E-mail:695234456@qq.com
 * @return
 */
@RestController
public class IndexController {


    @PostMapping("/index")
    public Object index(@RequestBody SystemParamDTO systemParam) {
        DubboFactory dubboFactory = new DubboFactory("civism-gateway", "127.0.0.1:2181", "zookeeper");

        return null;
    }
}
