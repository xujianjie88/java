package com.xjj.java.timetasks;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @description: �̳߳�ʵ�ֶ�ʱ����
 * @author: xujianjie
 * @create: 2021-06-26 11:32
 **/
public class ThreadPoolTimerTasksDemo {
    static int count  = 0;

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("����Threadʵ�ֶ�ʱ����count=" + count++);
            }
        };
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(runnable,1,1, TimeUnit.SECONDS);
    }

}
