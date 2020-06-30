package com.xjj.java.threadlocal.example;

public class SafeThreadLocal {

    private static ThreadLocal<Integer> threadLocal
            = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadLocal.set(threadLocal.get() + 1);
            }
            System.out.println("count: " + threadLocal.get());
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadLocal.set(threadLocal.get() + 1);
            }
            System.out.println("count: " + threadLocal.get());
        }).start();
    }
}
