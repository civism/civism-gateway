package com.civism.gateway;

import com.civism.gateway.core.service.DubboService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/8/18 9:36
 * @E-mail:695234456@qq.com
 * @return
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DubboCoreTest {

    @Resource
    private DubboService dubboService;

    @Test
    public void testCall() {
        Object o = dubboService.callBack(null);
        System.out.println(o);
    }
}
