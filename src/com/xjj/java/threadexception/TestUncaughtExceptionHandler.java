package com.xjj.java.threadexception;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 测试多线程捕获线程
 * @author: xujianjie
 * @create: 2021-06-25 15:30
 **/
public class TestUncaughtExceptionHandler {


    private static ThreadFactory factory = new ThreadFactory() {
        private final AtomicInteger integer = new AtomicInteger();
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "ThreadPool thread: " + integer.getAndIncrement());
        }
    };



    /**
     * Thread.UncaughtExceptionHandler
     */
    @Test
    public void test() {
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int i = 1 / 0;
                }
            });
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.out.println("uncaughtException:"+e.getMessage());
                }
            });
            thread.start();
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    /**
     * 测试线程池方式
     */

    private static ThreadPoolExecutor executorPool = new ThreadPoolExecutor(4, 20,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1),
            factory,
            new ThreadPoolExecutor.DiscardOldestPolicy()
    ) {
        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);
            if (t == null && r instanceof Future<?>) {
                try {
                    Object result = ((Future<?>) r).get();
                } catch (CancellationException ce) {
                    t = ce;
                } catch (ExecutionException ee) {
                    t = ee.getCause();
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt(); // ignore/reset
                }
            }
            if (t != null) {
                System.out.println("t is :" + t);
                t.printStackTrace();
            }
        }
    };


    @Test
    public void testThreadPoolCatchException(){
        executorPool.execute(new Runnable() {
            @Override
            public void run() {
                int a = 10/0;
            }
        });
    }

}
