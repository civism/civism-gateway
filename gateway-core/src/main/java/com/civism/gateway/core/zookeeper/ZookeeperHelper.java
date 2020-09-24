package com.civism.gateway.core.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/8/18 10:43
 * @E-mail:695234456@qq.com
 * @return
 */
public class ZookeeperHelper {

    private String address;

    private int sessionTimeoutMs;

    private int connectionTimeoutMs;

    private RetryPolicy retryPolicy;

    public ZookeeperHelper(String address, int sessionTimeoutMs, int connectionTimeoutMs) {
        this(address, sessionTimeoutMs, connectionTimeoutMs, null);
    }

    public ZookeeperHelper(String address, int sessionTimeoutMs, int connectionTimeoutMs, RetryPolicy retryPolicy) {
        this.address = address;
        this.sessionTimeoutMs = sessionTimeoutMs;
        this.connectionTimeoutMs = connectionTimeoutMs;
        if (retryPolicy == null) {
            this.retryPolicy = new ExponentialBackoffRetry(1000, 3);
        } else {
            this.retryPolicy = retryPolicy;
        }
    }

    public CuratorFramework getClient() throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString(address).sessionTimeoutMs(sessionTimeoutMs)
                .connectionTimeoutMs(connectionTimeoutMs).retryPolicy(retryPolicy).build();
        client.start();
        return client;
    }


}
