package com.xjj.java.thread03;

import java.lang.Thread.State;


/**
 * �̵߳�����״̬
 * @author Administrator
 *
 */
public class AllStatus {
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(()->{
			for(int i=0;i<5;i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(",,,,");
			}
		});
		
		State state = thread.getState();
		System.out.println(state);//NEW
		
		thread.start();
		
		state = thread.getState();
		System.out.println(state);//RUNNABLE
	
	     while(state!= State.TERMINATED) {
	    	Thread.sleep(200);
	    	state = thread.getState();
	 		System.out.println(state);//TIMED_WAITING
	     }
	     
	     state = thread.getState();
	     System.out.println(state);//TERMINATED
	}

}
