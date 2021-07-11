package com.xjj.java.timetasks;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @description: 方式二：java.util.TimerTask实现定时任务
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
                        //额外知识Thread.sleep是不会释放锁的
                        Thread.sleep(1000);
                        System.out.println("测试Thread实现定时任务count=" + count++);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Timer timer = new Timer();
        //天数
        int delay = 0;
        //秒数
        int period = 1;
        timer.scheduleAtFixedRate(timerTask,delay,period);
    }

}
