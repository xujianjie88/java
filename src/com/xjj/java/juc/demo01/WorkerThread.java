package com.xjj.java.juc.demo01;

import lombok.Data;

@Data
public class WorkerThread extends Thread{

    private String threadName;
    private Integer sleepSecond;
    private Boolean result;

    public WorkerThread(String name, Integer sleepSecond, Boolean result){
        this.sleepSecond = sleepSecond;
        this.threadName = name;
        this.result = result;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(sleepSecond * 1000);
            System.out.println("Thread-"+ threadName +"end.....");
            result = true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
