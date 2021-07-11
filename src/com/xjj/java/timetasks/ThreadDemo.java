package com.xjj.java.timetasks;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description: ��ʽһ��Threadʵ�ֶ�ʱ����
 * @author: xujianjie
 * @create: 2021-06-26 11:19
 **/
public class ThreadDemo {

    private static int count = 0;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        //����֪ʶThread.sleep�ǲ����ͷ�����
                        Thread.sleep(1000);
                        System.out.println("����Threadʵ�ֶ�ʱ����count=" + count++);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
