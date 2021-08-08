package com.xjj.java.jdk8.feturable;

import com.xjj.java.jdk8.feturable.utils.SmallTool;

import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-08-01 10:47
 **/
public class Completable_ThenApplyAsync_Test05 {

    /**
     * 小白吃完饭了，给钱给服务员
     * 服务员收款
     * 服务员开发票
     * @param args
     */
    public static void main(String[] args) {

        SmallTool.printTimeAndThread("小白吃完饭了，给500元给服务员");
        SmallTool.printTimeAndThread("小白吃完饭了，给500元给服务员");
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("服务员收到500元");
            SmallTool.sleepMills(200);
            return "500元";
        }).thenApplyAsync(money -> {
            //thenApplyAsync拿到上一个线程的结果,再执行下一个异步线程
            SmallTool.printTimeAndThread(String.format("服务员开发票的面额 %s", 500));
            SmallTool.sleepMills(200);
            return String.format("%s 元发票", money);
        });
        SmallTool.printTimeAndThread(String.format("小白拿着 %s 走了",cf.join()));
    }

}
