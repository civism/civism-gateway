package com.civism.gateway.core.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/8/18 13:45
 */
@Data
@Component
@ConfigurationProperties(prefix = "zookeeper")
public class ZookeeperConfig {

    @Value("${dubbo.registry.address}")
    private String address;

    @Value("${zookeeper.sessionTimeoutMs}")
    private int sessionTimeoutMs;

    @Value("${zookeeper.connectionTimeoutMs}")
    private int connectionTimeoutMs;

}
