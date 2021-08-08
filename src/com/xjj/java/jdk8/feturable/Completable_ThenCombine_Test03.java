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
     * 案例：
     * 1、小白点菜
     * 2、小白点了番茄炒蛋
     * 3、厨师线程：厨师炒菜
     * 4、服务员线程：服务员端菜+打饭
     * @param args
     */
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("小白进入餐厅");
        SmallTool.printTimeAndThread("小白点了 番茄炒蛋 + 一碗米饭");
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("厨师炒菜");
            SmallTool.sleepMills(200);
            return "番茄炒蛋";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            //thenCombine 厨师炒菜和服务员打饭两个异步线程并行执行
            SmallTool.printTimeAndThread("服务员打饭");
            SmallTool.sleepMills(200);
            return "米饭";
         }),(dish,rice)->{
            //返回两个异步线程执行结合的结果
          return String.format("%s+%s",dish,rice);
        });
        SmallTool.printTimeAndThread(String.format("%s,小白开吃",cf.join()));
    }

}
