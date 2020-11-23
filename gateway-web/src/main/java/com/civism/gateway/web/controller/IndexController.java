package com.civism.gateway.web.controller;

import com.civism.gateway.common.Result;
import com.civism.gateway.common.SystemParamDTO;
import com.civism.gateway.service.RouterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/8/8 11:25
 */
@RestController
public class IndexController {

    @Resource
    private RouterService routerService;

    @PostMapping("/index")
    public Result<Object> index(@RequestBody SystemParamDTO systemParam) {
        Object route = routerService.route(systemParam);
        return Result.success(route);
    }
}
