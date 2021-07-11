package com.xjj.java.timetasks;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description: 方式一：Thread实现定时任务
 * @author: xujianjie
 * @create: 2021-06-26 11:19
 **/
public class ThreadDemo {

    private static int count = 0;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        //额外知识Thread.sleep是不会释放锁的
                        Thread.sleep(1000);
                        System.out.println("测试Thread实现定时任务count=" + count++);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
