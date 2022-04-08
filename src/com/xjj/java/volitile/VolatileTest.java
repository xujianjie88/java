package com.xjj.java.volitile;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java内存模型相关介绍：https://www.cnblogs.com/dolphin0520/p/3920373.html
 */
public class VolatileTest {

    // 乐观锁
    Lock lock = new ReentrantLock();

    // AtomicInteger
    public AtomicInteger atomicInteger = new AtomicInteger();

    // volatile:
    // 1、保证了线程之间的可见性
    // 2、禁止指令重排序,在一定程度上保证有序性
//    public volatile int i = 0;
    public int i = 0;

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        for (int j = 0; j < 10; j++) {
            new Thread(() -> {
                // 没有加锁保证不了原子性,依旧是线程不安全
//                volatileTest.increaseUnSafe();
                // 加锁才能保证原子性
//                volatileTest.increaseSafe();
                // 乐观锁
//                volatileTest.increaseByLock();
                // AtomicInteger
                volatileTest.increaseByAutoInteger();
            }).start();
        }
    }

    /**
     * 加锁了，保证了线程安全
     *
     * @return
     */
    private void increaseUnSafe() {
        // 这个不是原子操作
        i = i + 1;
        System.out.println(Thread.currentThread().getName() + "," + "i的值为:" + i);
    }

    /**
     * 加锁了，保证了线程安全
     *
     * @return
     */
    private synchronized void increaseSafe() {
        i = i + 1;
        System.out.println(Thread.currentThread().getName() + "," + "i的值为:" + i);
    }

    /**
     * 加锁了，保证了线程安全
     *
     * @return
     */
    private void increaseByLock() {
        lock.lock();
        try {
            i = i + 1;
            System.out.println(Thread.currentThread().getName() + "," + "i的值为:" + i);
        } finally {
            lock.unlock();
        }
    }

    /**
     * atomicInteger
     */
    private void increaseByAutoInteger() {
//        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.getAndIncrement());
    }

}
