package com.xjj.java.thread02;

import com.xjj.java.thread.Web12306;

/**
 * sleep≤‚ ‘µπº∆ ±
 * @author Administrator
 *
 */
public class BlockThread2{
	
	public static void main(String[] args) throws InterruptedException {
		int num =10;
		while(true) {
			Thread.sleep(1000);
			System.out.println(num--);
		}
	}
	

}
