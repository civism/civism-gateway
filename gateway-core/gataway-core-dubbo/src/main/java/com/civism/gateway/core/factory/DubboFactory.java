package com.civism.gateway.core.factory;

import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/8/10 15:35
 */
public class DubboFactory {

    private String address;

    private String protocol;

    public DubboFactory(String name, String address, String protocol) {
        this.address = address;
        this.protocol = protocol;
        DubboBootstrap instance = DubboBootstrap.getInstance();
        instance.application(name);
    }

    public Object call(String interfaceName, String method, String version, String[] parameterTypes, Object[] args) {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setInterface(interfaceName);
        reference.setVersion(version);
        reference.setGeneric("true");
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setCheck(false);
        registryConfig.setAddress(address);
        registryConfig.setProtocol(protocol);
        reference.setRegistry(registryConfig);
        // ReferenceConfig实例很重，封装了与注册中心的连接以及与提供者的连接，
        // 需要缓存，否则重复生成ReferenceConfig可能造成性能问题并且会有内存和连接泄漏。
        // API方式编程时，容易忽略此问题。
        // 这里使用dubbo内置的简单缓存工具类进行缓存
        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(reference);
        return genericService.$invoke(method, parameterTypes, args);
    }


//    public static void main(String[] args) {
//        DubboFactory dubboFactory = new DubboFactory("civism-gateway", "127.0.0.1:2181", "zookeeper");
//        Object sayHello = dubboFactory.call("com.example.demo.service.HelloService", "sayHello", null, new String[]{}, new Object[]{});
//        System.out.println(sayHello);
//    }


}
