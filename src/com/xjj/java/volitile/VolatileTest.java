package com.xjj.java.volitile;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java�ڴ�ģ����ؽ��ܣ�https://www.cnblogs.com/dolphin0520/p/3920373.html
 */
public class VolatileTest {

    // �ֹ���
    Lock lock = new ReentrantLock();

    // AtomicInteger
    public AtomicInteger atomicInteger = new AtomicInteger();

    // volatile:
    // 1����֤���߳�֮��Ŀɼ���
    // 2����ָֹ��������,��һ���̶��ϱ�֤������
//    public volatile int i = 0;
    public int i = 0;

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        for (int j = 0; j < 10; j++) {
            new Thread(() -> {
                // û�м�����֤����ԭ����,�������̲߳���ȫ
//                volatileTest.increaseUnSafe();
                // �������ܱ�֤ԭ����
//                volatileTest.increaseSafe();
                // �ֹ���
//                volatileTest.increaseByLock();
                // AtomicInteger
                volatileTest.increaseByAutoInteger();
            }).start();
        }
    }

    /**
     * �����ˣ���֤���̰߳�ȫ
     *
     * @return
     */
    private void increaseUnSafe() {
        // �������ԭ�Ӳ���
        i = i + 1;
        System.out.println(Thread.currentThread().getName() + "," + "i��ֵΪ:" + i);
    }

    /**
     * �����ˣ���֤���̰߳�ȫ
     *
     * @return
     */
    private synchronized void increaseSafe() {
        i = i + 1;
        System.out.println(Thread.currentThread().getName() + "," + "i��ֵΪ:" + i);
    }

    /**
     * �����ˣ���֤���̰߳�ȫ
     *
     * @return
     */
    private void increaseByLock() {
        lock.lock();
        try {
            i = i + 1;
            System.out.println(Thread.currentThread().getName() + "," + "i��ֵΪ:" + i);
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
