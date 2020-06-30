package com.xjj.java.thread02;
/**
 * join合并线程，插队线程
 * @author Administrator
 *
 */
public class BlockJoin {
      public static void main(String[] args) throws InterruptedException {
    	  Thread thread = new Thread(()->{
  			for(int i=0;i<100;i++) {
  				System.out.println("lambda"+i);
  			}
  		});
    	thread.start();
  		
  		for(int i=0;i<100;i++) {
  			System.out.println("main:"+i);
  			if(i==20) {
  				thread.join();//main线程阻塞
  			}
  		}
	}
}
