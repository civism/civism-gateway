package com.civism.gateway.core.config;

import com.civism.gateway.core.factory.DubboFactory;
import com.civism.gateway.core.zookeeper.ZookeeperHelper;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/8/18 9:27
 * @E-mail:695234456@qq.com
 * @return
 */
@Configuration
public class BeanFactoryConfig {

    @Resource
    private DubboConfig dubboConfig;

    @Resource
    private ZookeeperConfig zookeeperConfig;

    @Bean
    public DubboFactory getDubbo() {
        return new DubboFactory(dubboConfig.getName(), dubboConfig.getAddress(), dubboConfig.getProtocol());
    }

    @Bean
    public CuratorFramework getZookeeper() {
        try {
            return new ZookeeperHelper(zookeeperConfig.getAddress(), zookeeperConfig.getSessionTimeoutMs(), zookeeperConfig.getConnectionTimeoutMs()).getClient();
        } catch (Exception e) {
            throw new RuntimeException("初始化bean失败");
        }
    }


}
