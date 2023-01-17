package com.xjj.java.ratelimit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ������������
 */
public class RateLimiterTest {

    public static ExecutorService executorService = Executors.newFixedThreadPool(5);

    /**
     * ÿ����ͨ��һ���߳�,��һ���������߳�����,�ڶ�����ʱ��
     */
    private static final RateLimiter rateLimiter = RateLimiter.create(1, 1, TimeUnit.SECONDS);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                testRateLimiter();
            });
        }
    }

    private static void testRateLimiter() {
        double acquire = rateLimiter.acquire();
        System.out.println(Thread.currentThread().getName() + ": elapsed seconds " + acquire);
        System.out.println("do something...");
    }

}
