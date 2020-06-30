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
			//Thread类中的join方法的主要作用就是同步，它可以使得线程之间的并行执行变为串行执行。

			/**join的意思是使得放弃当前线程的执行，并返回对应的线程，例如下面代码的意思就是：
			 程序在main线程中调用t1线程的join方法，则main线程放弃cpu控制权，并返回t1线程继续执行直到线程t1执行完毕
			 所以结果是t1线程执行完后，才到主线程执行，相当于在main线程中同步t1线程，t1执行完了，main线程才有执行的机会
			 */
			thread.join();
		}
		//输出结果：28782，  100000
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(list.size());
	}

}
