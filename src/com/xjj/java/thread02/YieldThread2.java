package com.xjj.java.thread02;

/**
 * 测试Yield礼让线程，暂停线程，不是阻塞而是就绪
 * @author Administrator
 *
 */
public class YieldThread2 {
	
	public static void main(String[] args) {
		MyYield myYield = new MyYield();
		new Thread(myYield,"a").start();
		new Thread(myYield,"b").start();
		
	}

}

class MyYield implements Runnable{

	@Override
	public void run() {
    System.out.println(Thread.currentThread().getName()+"-->start");
    Thread.yield();//礼让,并不是每次都成功
    System.out.println(Thread.currentThread().getName()+"-->end");		
	}
	
}
