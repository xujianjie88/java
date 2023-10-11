package com.xjj.java.countdownlatch;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchDemo02 {


    public static void main(String[] args) {
        ThreadPoolExecutor executorService = getThreadPoolExecutor();
        new Thread(()->{
            testCountDownLatch(executorService);
        }).start();

        new Thread(()->{
            testCountDownLatch(executorService);
        }).start();
    }

    private static void testCountDownLatch(ThreadPoolExecutor executorService) {
        System.out.println("程序执行开始");
        List<String> stringList = Lists.newArrayList();
        int maxThread = 1000;
        for (int i = 0; i < maxThread; i++) {
            stringList.add(String.valueOf(i));
        }
        List<String> resultList =  Collections.synchronizedList(Lists.newArrayList());
        List<List<String>> partition = Lists.partition(stringList, 200);
        for (List<String> strings : partition) {
            CountDownLatch countDownLatch = new CountDownLatch(strings.size());
            try {
                strings.forEach(s -> {
                    executorService.execute(() -> {
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(s);
                        resultList.add(s);
                        countDownLatch.countDown();
                    });
                });
            } catch (Exception e) {
                countDownLatch.countDown();
                System.out.println(e.getMessage());
            }

            try {
                // 加上超时时间是因为有可能线程数不够用，防止线程一致等待
                countDownLatch.await(15,TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("程序执行结束");
        System.out.println(resultList);
    }

    private static ThreadPoolExecutor getThreadPoolExecutor() {
        int corePoolSize = 20;
        int maximumPoolSize = 300;
        long keepAliveTime = 60;
        int queueCapacity = 0;
        TimeUnit unit = TimeUnit.SECONDS;

        BlockingQueue<Runnable> workQueue = null;
        if (queueCapacity==0) {
            workQueue = new SynchronousQueue<>();//同步队列
        }
        if (queueCapacity>0) {
            workQueue = new LinkedBlockingQueue<>(queueCapacity);//有界队列
        }
        if (queueCapacity<0) {
            workQueue = new LinkedBlockingQueue<>();//无界队列，可能将所有内存占满
        }

        ThreadFactory threadFactory = new MyDefaultThreadFactory("pool");
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
//        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();

        ThreadPoolExecutor executorService = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler);
        return executorService;
    }


    static class MyDefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        MyDefaultThreadFactory(String taskPoolKey) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "my-"+taskPoolKey+"-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }

}
