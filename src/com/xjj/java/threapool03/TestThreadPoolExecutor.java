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
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                100,1, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("xujianjie");
                }
            });
        }
        //关闭线程池
        threadPoolExecutor.shutdown();
    }

}
