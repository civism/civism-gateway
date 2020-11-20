package com.civism.gateway.core.watcher;

import com.civism.gateway.core.constants.GatewayConstants;
import lombok.SneakyThrows;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/9/18 11:17
 * @E-mail:695234456@qq.com
 * @return
 */
@Service
public class GateWayRegisterWatcher implements InitializingBean, Watcher {

    @Resource
    private CuratorFramework curatorFramework;

    public void registerWatcher() throws Exception {
//        curatorFramework.getData().usingWatcher(this).forPath(GatewayConstants.ROOTNODE);
        List<String> strings = curatorFramework.getChildren().forPath(GatewayConstants.ROOTNODE);
        System.out.println();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.registerWatcher();
    }

    @SneakyThrows
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("监听 监听 =================");
        List<String> strings = curatorFramework.getChildren().watched().forPath(GatewayConstants.ROOTNODE);
        System.out.println(Arrays.asList(strings));
    }
}
