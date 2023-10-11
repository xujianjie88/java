package com.xjj.java.threapool03;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: 测试自带的线程池类
 * @author: xujianjie
 * @create: 2021-06-20 23:02
 **/
public class TestThreadPoolExecutor {

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            runTask();
        }
    }

    private static void runTask() {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(50,
                1000,1, TimeUnit.SECONDS,new LinkedBlockingDeque<>(2000));

        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    doBusiness();
                    System.out.println("xujianjie");
                }
            });
        }
        //关闭线程池
        threadPoolExecutor.shutdown();
    }

    private static void doBusiness() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
