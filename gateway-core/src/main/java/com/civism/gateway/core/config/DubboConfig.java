package com.civism.gateway.core.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/8/17 17:23
 */
@Data
@Component
@ConfigurationProperties(prefix = "dubbo")
public class DubboConfig {

    @Value("${dubbo.application.name}")
    private String name;

    @Value("${dubbo.registry.address}")
    private String address;

    @Value("${dubbo.registry.protocol}")
    private String protocol;

}
