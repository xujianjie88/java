package com.xjj.java.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * 死锁故障定位排查：
 * 1. 打开Terminal
 * 2. 输入命令 jps -l 查看有问题的Java类  // jps -l
 * 3. 输入命令 jstack 有问题的线程号      // jstack 9368
 * 4. 报出错误： Found 1 deadlock.
 */
public class HoldLockThread  implements Runnable {

    //模拟锁
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {

        //第一把锁
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t 尝试获得：" + lockB);
            //暂停2秒,充分看到锁的效果
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            //第二把锁
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockB + "\t 尝试获得：" + lockA);
            }
        }
    }

    //验证
    public static void main(String[] args) {
        //模拟锁变量
        String lockA = "lockA";
        String lockB = "lockB";

        //开启线程
        new Thread(new HoldLockThread(lockA, lockB), "ThreadAAA").start();

        new Thread(new HoldLockThread(lockB, lockA), "ThreadBBB").start();
    }
}
