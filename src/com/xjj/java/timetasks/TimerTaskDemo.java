package com.xjj.java.timetasks;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @description: ��ʽ����java.util.TimerTaskʵ�ֶ�ʱ����
 * @author: xujianjie
 * @create: 2021-06-26 11:24
 **/
public class TimerTaskDemo {

    static int count = 0;

    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
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
        };

        Timer timer = new Timer();
        //����
        int delay = 0;
        //����
        int period = 1;
        timer.scheduleAtFixedRate(timerTask,delay,period);
    }

}
