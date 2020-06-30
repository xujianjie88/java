package com.xjj.java.threadlocal.example;

/**
 *
 *   启动两个线程，各执行100次对共享变量count加1，得到的结果可能并不是200，而是一个无法确定的数
 */
public class UnSafeThreadLocal {

    static int count = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
            System.out.println("count: " + count);
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
            System.out.println("count: " + count);
        }).start();
    }
}
