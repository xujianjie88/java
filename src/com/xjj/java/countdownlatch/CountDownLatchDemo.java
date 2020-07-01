package com.xjj.java.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 *
 * CountDownLatch是java.util.concurrent包中的一个同步辅助类，在完成一组正在其他线程中执行的操作之前，
 * 它允许一个或多个线程一直等待。它主要用来协调多个线程之间的同步，起到一个同步器的作用。
 * 总的来说，CountDownLatch让一个或多个线程在运行过程中的某个时间点能停下来等待其他的一些线程完成某些任务后再继续运行。
 *
 *
 * countDown
 * 递减锁存器的计数，如果计数到达零，则释放所有等待的线程。
 * 如果当前计数大于零，则将其递减。
 * 如果新计数为零，则将重新启用所有等待线程以进行线程调度。
 * 如果当前计数等于零，则不发生任何操作。
 *
 * await
 * 由于调用 countDown()方法，计数到达零；或者
 * 其他某个线程中断当前线程；或者
 * 已超出指定的等待时间。
 *
 */
public class CountDownLatchDemo {

        public static void main(String[] args) throws InterruptedException {
            CountDownLatch count = new CountDownLatch(10);
            for (int i = 0; i < 10; i++) {
                new Thread(() -> {
                    System.out.println(Thread.currentThread().getName() + "吃完饭了，离开了");
                    count.countDown();
                },String.valueOf(i) ).start();
            }
            count.await();
            System.out.println(Thread.currentThread().getName() + "我要去洗碗了");
        }

}
