package com.xjj.java.volatiles;

/**
 * 保证多线程,变量值的可见性
 */
public class VolatileTest02 extends Thread{

    // 不加volatile,主线程读取到的stopFlag一直是false退出不了循环
    private volatile boolean stopFlag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stopFlag = true;
    }

    public boolean isStopFlag() {
        return stopFlag;
    }

    public static void main(String[] args) {
        VolatileTest02 volatileDemo = new VolatileTest02();
        volatileDemo.start();

        while (true){
            if (volatileDemo.isStopFlag()){
                System.out.println("exit while ...");
                break;
            }
        }
    }


}
