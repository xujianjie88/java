package com.xjj.java.jdk8.feturable;

import com.xjj.java.jdk8.feturable.utils.SmallTool;

import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-08-01 10:26
 **/
public class Completable_ThenCompose_Test02 {


    /**
     * ������
     * 1��С�׵��
     * 2��С�׵��˷��ѳ���
     * 3����ʦ�̣߳���ʦ����
     * 4������Ա�̣߳�����Ա�˲�+��
     * @param args
     */
    public static void main(String[] args) {

        SmallTool.printTimeAndThread("С�׽������");
        SmallTool.printTimeAndThread("С�׵��� ���ѳ��� + һ���׷�");
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("��ʦ����");
            SmallTool.sleepMills(200);
            return "���ѳ���";
        }).thenCompose(dish->CompletableFuture.supplyAsync(()->{
            //thenCompose ��ǰһ������ִ���н������һ���첽����Ŵ���
            SmallTool.printTimeAndThread("����Ա��");
            SmallTool.sleepMills(200);
            return dish+ "�׷�";
         }));
        SmallTool.printTimeAndThread(String.format("%s,С�׿���",cf.join()));
    }

}
