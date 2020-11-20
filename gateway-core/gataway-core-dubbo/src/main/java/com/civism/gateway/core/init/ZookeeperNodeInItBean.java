package com.civism.gateway.core.init;

import com.civism.gateway.core.constants.GatewayConstants;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/8/26 10:46
 * @E-mail:695234456@qq.com
 * @return
 */
@Component
public class ZookeeperNodeInItBean implements InitializingBean {

    @Resource
    private CuratorFramework curatorFramework;


    //创建节点
    public void initNode() {
        try {
            Stat stat = curatorFramework.checkExists().forPath(GatewayConstants.ROOTNODE);
            if (stat == null) {
                curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath(GatewayConstants.ROOTNODE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        initNode();
    }
}
