package com.xjj.java.thread02;

import com.xjj.java.thread.Web12306;

/**
 * sleep测试网络的延时，放大发生问题的可能性
 * @author Administrator
 *
 */
public class BlockThread implements Runnable{
	
private int tickNums = 99;
	
	@Override
	public void run() {
		while(true) {
		 if(tickNums<0) {
			  break;
		 }
		 //模拟延时
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
