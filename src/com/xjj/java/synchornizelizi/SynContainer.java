package com.xjj.java.synchornizelizi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 并发容器
 *
 * @author Administrator
 */
public class SynContainer {

//	private static final Object objects = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 优点:线程安全,缺点:每次删除和修改的都需要重新生成数组,性能低
        // 底层实现:volatile + synchronized
        new Thread(() -> {
            copyOnWriteArrayList();
        }, "thread1").start();

        new Thread(() -> {
            arrayList();
        }, "thread2").start();

    }

    private static void arrayList() {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			new Thread(() -> {
				list.add(Thread.currentThread().getName());
			}).start();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println(Thread.currentThread().getName() + "list size:" + list.size());

    }

    private static void copyOnWriteArrayList() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "list size:" + list.size());
    }

}
