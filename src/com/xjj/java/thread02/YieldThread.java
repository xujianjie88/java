package com.xjj.java.thread02;

/**
 * 测试Yield礼让线程，暂停线程，不是阻塞而是就绪
 * @author Administrator
 *
 */
public class YieldThread {
	
	public static void main(String[] args) {
		new Thread(()->{
			for(int i=0;i<100;i++) {
				System.out.println("lambda"+i);
			}
		}).start();
		
		for(int i=0;i<100;i++) {
			System.out.println("main:"+i);
			if(i%20==0) {
				Thread.yield();
			}
		}
	}

}

