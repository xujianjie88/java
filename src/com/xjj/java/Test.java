package com.xjj.java;

import java.util.*;

public class Test {

//    public Integer num = 10;

    public Boolean getIsDegrade() {
        return isDegrade;
    }

    public void setIsDegrade(Boolean degrade) {
        isDegrade = degrade;
    }

    private Boolean isDegrade;

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,2,4);
        Test test = new Test();
        for(int i=0;i<100;i++){
            new Thread(()->{
                test.A();
            }).start();
        }
    }

    public void A(){
        Integer num = 10;
        num++;
        System.out.println(Thread.currentThread().getName()+":"+num);
        num--;
        System.out.println(Thread.currentThread().getName()+":"+num);
    }

    /**
     *
     */
    @org.junit.Test
    public void testArrayListAndLinkedListInsertMethod(){
        insertByList();
        insertByLinkedList();
    }

    private void insertByList() {
        long startTime = System.currentTimeMillis();
        List<String> strList = new ArrayList<>();
        for (int i=0;i<10000;i++){
            strList.add(i+"");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("arraylist insert cost time£º"+(endTime-startTime));
    }

    private void insertByLinkedList() {
        long startTime = System.currentTimeMillis();
        List<String> strList = new LinkedList<>();
        for (int i=0;i<10000;i++){
            strList.add(i+"");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("linkedlist insert cost time£º"+(endTime-startTime));
    }
}
