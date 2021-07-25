package com.xjj.java.jdk8;

import org.junit.Test;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-18 15:53
 **/
public class LambdaTest {


    public static void main(String[] args) {
        //jdk1.7֮ǰ����ʽ��ʹ�������ڲ����������߳�
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("��ǰ�̵߳�����:"+Thread.currentThread().getName());
            }
        }).start();

        //jdk1.8lambada����ʽ,lambada�������������������Ϊ�ɴ��ݴ���
        new Thread(()->{
            System.out.println("��ǰ�̵߳�����:"+Thread.currentThread().getName());
        }).start();

        System.out.println("���̵߳����ƣ�"+Thread.currentThread().getName());
    }


}
