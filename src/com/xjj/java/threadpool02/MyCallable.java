package com.xjj.java.threadpool02;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        //����ִ�е�ǰ Callable ���߳�����
        return Thread.currentThread().getName();
    }
}
