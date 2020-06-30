package com.xjj.java.thread;

/**
 * 共享资源，并发线程安全
 * @author Administrator
 *
 */
public class Web12306 implements Runnable{

	private int tickNums = 99;
	
	@Override
	public void run() {
		while(true) {
		 if(tickNums<0) {
			  break;
		 }
	    try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"-->"+tickNums--);
		}
	}
	
	public static void main(String[] args) {
		//一份资源
		Web12306 web12306 = new Web12306();
		//多个代理
		new Thread(web12306,"xu").start();
		new Thread(web12306,"huang").start();
		new Thread(web12306,"li").start();
	}
	
	

}
