package com.xjj.java.jdk8.feturable;

import com.xjj.java.jdk8.feturable.utils.SmallTool;

import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-08-01 10:47
 **/
public class Completable_ThenApply_Test04 {

    /**
     * С�׳��극�ˣ���Ǯ������Ա
     * ����Ա�տ�
     * ����Ա����Ʊ
     * @param args
     */
    public static void main(String[] args) {

        SmallTool.printTimeAndThread("С�׳��극�ˣ���500Ԫ������Ա");
        SmallTool.printTimeAndThread("С�׳��극�ˣ���500Ԫ������Ա");
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("����Ա�յ�500Ԫ");
            SmallTool.sleepMills(200);
            return "500Ԫ";
        }).thenApply(money -> {
            //thenApply
            SmallTool.printTimeAndThread(String.format("����Ա����Ʊ����� %s", 500));
            SmallTool.sleepMills(200);
            return String.format("%s Ԫ��Ʊ", 500);
        });
        SmallTool.printTimeAndThread(String.format("С������ %s ����",cf.join()));
    }

}
