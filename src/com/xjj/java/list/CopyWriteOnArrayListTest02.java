package com.xjj.java.list;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 弱一致性
 */
public class CopyWriteOnArrayListTest02 {

    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        new Thread(() -> {
            list.remove(0);
        }).start();
        System.out.println(list);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 弱一致性
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


}
