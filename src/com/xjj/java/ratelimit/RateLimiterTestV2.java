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
            // 每秒允许消费10个线程,不会超过10个线程
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
