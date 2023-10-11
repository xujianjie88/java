package com.xjj.java.countdownlatch;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.concurrent.*;

public class CountDownLatchDemo03 {

    public static void main(String[] args) {

        List<String> allStringList = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch countDownLatch = new CountDownLatch(5);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(()->{
                try {
                    allStringList.addAll(Objects.requireNonNull(asyncGetData()));
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {

        }
        executorService.shutdown();
        System.out.println(allStringList);
        System.out.println("Ö´ÐÐ½áÊø");
    }

    private static List<String> asyncGetData() {
        CompletableFuture<List<String>> future1 = CompletableFuture.supplyAsync(() -> {
            return Arrays.asList("1");
        });
        CompletableFuture<List<String>> future2 = CompletableFuture.supplyAsync(()-> Arrays.asList("2"));

        try {
            List<String> stringList1 = future1.get();
            List<String> stringList2 = future2.get();
            List<String> allStringList = Lists.newArrayList();
            allStringList.addAll(stringList1);
            allStringList.addAll(stringList2);
            return allStringList;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


}
