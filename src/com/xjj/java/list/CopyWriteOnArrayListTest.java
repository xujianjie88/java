package com.xjj.java.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyWriteOnArrayListTest {


    private static int capcity = 5;
    private static List<String> list = new CopyOnWriteArrayList<String>();
//    »áÅ×³öÒì³£ConcurrentModificationException
//    private static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        InnerThread t1 = new InnerThread();
        t1.start();
        InnerThread t2 =new InnerThread();
        t2.start();

    }
    static class InnerThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < capcity; i++) {
                list.add(String.valueOf(i));
                iteratorList(list);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+":"+list.toString());
            }

        }
    }
    public static void iteratorList(List list){
        Iterator iterator =list.iterator();
        while(iterator.hasNext()){
            iterator.next();
        }
    }
}
