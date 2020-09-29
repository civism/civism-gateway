package com.civism.gateway;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/9/22 17:47
 * @E-mail:695234456@qq.com
 * @return
 */
public class MainTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println(111111);
        executorService.submit(new Task());

        System.out.println("2222233321");

    }

    public static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("线城市");
            throw new RuntimeException("12333");
        }
    }


}
