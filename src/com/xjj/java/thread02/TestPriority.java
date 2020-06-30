package com.xjj.java.thread02;
/**
 * 线程的优先级
 * 1.NORM_PRIORITY  5(默认是5)
 * 2.MIN_PRIORITY  1
 * 3.MAX_PRIORITY  10
 * 
 * 优先级：只代表概率，不代表顺序
 * 
 * @author Administrator
 *
 */
public class TestPriority {
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getPriority());
		
		
		MyPriority myPriority = new MyPriority();
		
		Thread thread1 = new Thread(myPriority);
		Thread thread2 = new Thread(myPriority);
		Thread thread3 = new Thread(myPriority);
		Thread thread4 = new Thread(myPriority);
		Thread thread5 = new Thread(myPriority);
		Thread thread6 = new Thread(myPriority);
		
		//设置线程的优先级后启动
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread2.setPriority(Thread.MAX_PRIORITY);
		thread3.setPriority(Thread.MAX_PRIORITY);
		thread4.setPriority(Thread.MIN_PRIORITY);
		thread5.setPriority(Thread.MIN_PRIORITY);
		thread6.setPriority(Thread.MIN_PRIORITY);
		
		
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		
		
	}

}

class MyPriority implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority());
		Thread.yield();
	}
	
}
