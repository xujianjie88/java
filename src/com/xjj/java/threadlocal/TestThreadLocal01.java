package com.xjj.java.threadlocal;

import javax.print.attribute.standard.RequestingUserName;

/**
 * 每个线程自身的存储本地，局部区域
 * get/set/initalValue
 * @author Administrator
 *
 */
public class TestThreadLocal01 {
	
	//private static ThreadLocal<Integer> threadLocal= new ThreadLocal<>();

	//方法一:更改初始值
	private static ThreadLocal<Integer> threadLocal1= new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return 200;
		}; 
	};

	//方法二:jdk8
	private static ThreadLocal<Integer> threadLocal2= ThreadLocal.withInitial(()->300);
	
	public static void main(String[] args) {
		//获取值
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal1.get());
		//设置值
		threadLocal1.set(90);
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal1.get());
	
		//每个线程都有独立的空间，互不影响
		new Thread(new MyRun()).start();
		new Thread(new MyRun()).start();
	}
	
	public static class MyRun implements Runnable{
		@Override
		public void run() {
			threadLocal1.set((int)(Math.random()*99));
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal1.get());
		}
	}
	
}

