package com.xjj.java.jdk8.feturable;

import com.xjj.java.jdk8.feturable.utils.SmallTool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.FutureTask;

/**
 * @description:�����첽�߳�
 * @author: xujianjie
 * @create: 2021-08-01 10:03
 **/
public class CompletableTest01 {

    /**
     * ������
     * 1��С�׵��
     * 2��С�׵��˷��ѳ���
     * 3����ʦ����
     * 4����ʦ��
     * @param args
     */
    public static void main(String[] args) {

        SmallTool.printTimeAndThread("С�׽������");
        SmallTool.printTimeAndThread("С�׵��� ���ѳ��� + һ���׷�");

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("��ʦ����");
            SmallTool.sleepMills(200);
            SmallTool.printTimeAndThread("��ʦ��");
            SmallTool.sleepMills(100);
            return "���ѳ��� +�׷�������";
        });
        SmallTool.printTimeAndThread(String.format("%s,С�׿���",cf.join()));
    }


}
