package com.xjj.java.jdk8.feturable;

import com.xjj.java.jdk8.feturable.utils.SmallTool;

import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-08-01 10:26
 **/
public class Completable_ThenCombine_Test03 {


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
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            //thenCombine ��ʦ���˺ͷ���Ա�������첽�̲߳���ִ��
            SmallTool.printTimeAndThread("����Ա��");
            SmallTool.sleepMills(200);
            return "�׷�";
         }),(dish,rice)->{
            //���������첽�߳�ִ�н�ϵĽ��
          return String.format("%s+%s",dish,rice);
        });
        SmallTool.printTimeAndThread(String.format("%s,С�׿���",cf.join()));
    }

}
