package com.xjj.java.jdk8.feturable.utils;

import java.util.StringJoiner;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-08-01 10:13
 **/
public class SmallTool {

    public static void sleepMills(long mills){
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void printTimeAndThread(String tag){
        String res = new StringJoiner("\t\t")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(tag)
                .toString();
        System.out.println(res);
    }


}
