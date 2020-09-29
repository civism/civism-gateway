package com.civism.gateway.core.init;


import com.civism.gateway.core.annotation.RpcController;
import com.civism.gateway.core.annotation.UrlPatch;
import com.civism.gateway.core.constants.GatewayConstants;
import lombok.SneakyThrows;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/8/18 16:51
 */
@Component
public class UrlPatchNodeInitBean implements ApplicationContextAware {

    @Resource
    private CuratorFramework curatorFramework;

    @SneakyThrows
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(RpcController.class);
        if (CollectionUtils.isEmpty(beansWithAnnotation)) {
            return;
        }
        for (Map.Entry<String, Object> entry : beansWithAnnotation.entrySet()) {
            Object value = entry.getValue();
            Class<?>[] interfaces = value.getClass().getInterfaces();
            StringBuilder root = new StringBuilder(GatewayConstants.ROOTNODE);
            for (Class<?> clazz : interfaces) {
                RpcController annotation1 = clazz.getAnnotation(RpcController.class);
                root.append("/");
                String s = annotation1.value().replaceFirst("/", "").replaceAll("/", "-");
                root.append(s);
                for (Method method : clazz.getMethods()) {
                    UrlPatch annotation = method.getAnnotation(UrlPatch.class);
                    if (annotation == null) {
                        continue;
                    }
                    String[] urls = annotation.url();
                    for (String url : urls) {
                        StringBuilder nodePath = new StringBuilder();
                        if (url.startsWith("/")) {
                            nodePath.append(url.replaceAll("/", "-"));
                        } else {
                            nodePath.append("-").append(url);
                        }
                        nodePath.append("/").append(clazz.getName()).append("#").append(method.getName());
                        curatorFramework.create().creatingParentContainersIfNeeded().withProtection().withMode(CreateMode.EPHEMERAL).forPath(root.toString().concat(nodePath.toString()));
                    }
                }
            }
        }
    }


}
