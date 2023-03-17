package com.xjj.java.threadunsafedemo;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;
import java.util.Vector;

public class UnSafeDemo01 {

    public static void main(String[] args) throws InterruptedException {
        User user = new User();
//        List<Integer> unsafeList = Lists.newArrayList();
        List<Integer> safeList = new Vector<>();
        List<Thread> threadList = Lists.newArrayList();
        for (int i = 0; i < 10000; i++) {
            // ����̶߳Թ������unsafeList ���Ԫ��,�����̰߳�ȫ����
            Thread thread = new Thread(() -> {
//                unsafeList.add(getUserList()); // �������,�����̰߳�ȫ����
//                user.setId(getUserList()); // �������,�����̰߳�ȫ����
                safeList.add(getUserList());
            });
            threadList.add(thread);
            thread.start();
        }
        for (Thread thread : threadList) {
            thread.join();
        }
        System.out.println(user.getId());
        System.out.println(safeList);
        System.out.println(safeList.size());
    }

    private static Integer getUserList() {
        return new Random().nextInt(3);
    }

}
