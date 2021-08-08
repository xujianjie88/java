package com.xjj.java.jdk8.feturable;

import com.xjj.java.jdk8.feturable.utils.SmallTool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.FutureTask;

/**
 * @description:测试异步线程
 * @author: xujianjie
 * @create: 2021-08-01 10:03
 **/
public class CompletableTest01 {

    /**
     * 案例：
     * 1、小白点菜
     * 2、小白点了番茄炒蛋
     * 3、厨师炒菜
     * 4、厨师打饭
     * @param args
     */
    public static void main(String[] args) {

        SmallTool.printTimeAndThread("小白进入餐厅");
        SmallTool.printTimeAndThread("小白点了 番茄炒蛋 + 一碗米饭");

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("厨师炒菜");
            SmallTool.sleepMills(200);
            SmallTool.printTimeAndThread("厨师打饭");
            SmallTool.sleepMills(100);
            return "番茄炒蛋 +米饭做好了";
        });
        SmallTool.printTimeAndThread(String.format("%s,小白开吃",cf.join()));
    }


}
