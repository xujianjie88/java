package com.xjj.java.ratelimit;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RateLimiterTestV2 {


    public static ExecutorService executorService = Executors.newFixedThreadPool(5);
    private static final RateLimiter rateLimiter = RateLimiter.create(10.0); // rate is "2 permits per second"

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            // ÿ����������10���߳�,���ᳬ��10���߳�
            rateLimiter.acquire();
            executorService.execute(() -> {
                testRateLimiter();
            });
        }
    }
    private static void testRateLimiter() {
        System.out.println(Thread.currentThread().getName() + " do something ..." + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
