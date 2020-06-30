package com.xjj.java.threadlocal;

import javax.print.attribute.standard.RequestingUserName;

/**
 * 每个线程存储自己的数据，更改不会影响其他线程
 * get/set/initalValue
 * @author Administrator
 *
 */
public class TestThreadLocal02 {
	

	//方法一:更改初始值
	private static ThreadLocal<Integer> threadLocal= ThreadLocal.withInitial(()->1);

	public static void main(String[] args) {
	  for(int i=0;i<5;i++) {
		  new Thread(new MyRun()).start();
	  }
	}
	
	public static class MyRun implements Runnable{
		@Override
		public void run() {
			Integer left = threadLocal.get();
			System.out.println(Thread.currentThread().getName()+"-->得到了"+left);
			threadLocal.set(left-1);
			System.out.println(Thread.currentThread().getName()+"-->剩下了"+threadLocal.get());
		}
	}
	
}

