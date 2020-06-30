package com.xjj.java.juc;

import java.util.concurrent.CountDownLatch;

/**
 * 有时候会有这样的需求，多个线程同时工作，然后其中几个可以随意并发执行，但有一个线程需要等其他线程工作结束后，才能开始。举个例子，
 * 开启多个线程分块下载一个大文件，每个线程只下载固定的一截，最后由另外一个线程来拼接所有的分段，那么这时候我们可以考虑使用CountDownLatch来控制并发。
 */
public class TestCountDownLatch {

    /**
     * 计数器，用来控制线程
     * 传入参数2，表示计数器计数为2
     */
    private final static CountDownLatch mCountDownLatch = new CountDownLatch(2);

    /**
     * 示例工作线程类
     */
    private static class WorkingThread extends Thread {
        private final String mThreadName;
        private final int mSleepTime;
        public WorkingThread(String name, int sleepTime) {
            mThreadName = name;
            mSleepTime = sleepTime;
        }

        @Override
        public void run() {
            System.out.println("[" + mThreadName + "] started!");
            try {
                Thread.sleep(mSleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //。countDown()调用release，从而导致计数器值递减，并且计数器值为零时，解除所有等待线程的阻塞。
            // await()调用accquie，当计数器值为零时，acquire将立即返回，否则将阻塞。
            mCountDownLatch.countDown();
            System.out.println("[" + mThreadName + "] end!");
        }
    }

    /**
     * 示例线程类
     */
    private static class SampleThread extends Thread {

        @Override
        public void run() {
            System.out.println("[SampleThread] started!");
            try {
                // 会阻塞在这里等待 mCountDownLatch 里的count变为0；
                // 也就是等待另外的WorkingThread调用countDown()
                mCountDownLatch.await();
            } catch (InterruptedException e) {

            }
            System.out.println("[SampleThread] end!");
        }
    }

    public static void main(String[] args) throws Exception {
        // 最先run SampleThread
        new SampleThread().start();
        // 运行两个工作线程
        // 工作线程1运行5秒
        new WorkingThread("WorkingThread1", 5000).start();
        // 工作线程2运行2秒
        new WorkingThread("WorkingThread2", 2000).start();
    }

}
