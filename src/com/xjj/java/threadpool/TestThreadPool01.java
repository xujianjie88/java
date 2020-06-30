package com.xjj.java.threadpool;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试不使用线程池的效率
 * @author Administrator
 *
 */
public class TestThreadPool01 {
	
	public static void main(String[] args) throws InterruptedException {
		
		Long start = System.currentTimeMillis();
		final List list = new ArrayList<>();
		for(int i=0;i<100000;i++) {
			final int j = i;
			Thread thread = new Thread() {
				@Override
				public void run() {
					list.add(j);
				}
			};
			thread.start();
			thread.join();
		}
		//输出结果：28782，  100000
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(list.size());
	}

}
