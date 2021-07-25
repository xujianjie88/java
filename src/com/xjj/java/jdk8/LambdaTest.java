package com.xjj.java.jdk8;

import org.junit.Test;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-18 15:53
 **/
public class LambdaTest {


    public static void main(String[] args) {
        //jdk1.7之前的形式，使用匿名内部类来创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程的名称:"+Thread.currentThread().getName());
            }
        }).start();

        //jdk1.8lambada的形式,lambada是匿名函数，可以理解为可传递代码
        new Thread(()->{
            System.out.println("当前线程的名称:"+Thread.currentThread().getName());
        }).start();

        System.out.println("主线程的名称："+Thread.currentThread().getName());
    }


}
