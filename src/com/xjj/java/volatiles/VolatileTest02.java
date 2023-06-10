package com.xjj.java.volatiles;

/**
 * ��֤���߳�,����ֵ�Ŀɼ���
 */
public class VolatileTest02 extends Thread{

    // ����volatile,���̶߳�ȡ����stopFlagһֱ��false�˳�����ѭ��
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
