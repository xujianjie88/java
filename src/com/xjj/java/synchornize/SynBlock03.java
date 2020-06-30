package com.xjj.java.synchornize;

/**
 * 线程安全:在并发时保证数据的正确性，效率尽可能高
 * synchornize
 * 1.同步方法
 * 2.同步块
 * 
 * @author Administrator
 *
 */
public class SynBlock03 implements Runnable{

	private int tickNums = 10;
	
	private boolean flag =true;
	
	@Override
	public void run() {
		while(flag) {
		 try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 test();
		}
	}
	
	//线程安全，同步，注意，锁的是this这个对象，不是方法
	public synchronized void test() {
		 if(tickNums<=0) {
			  flag = false;
			  return;
		 }
		System.out.println(Thread.currentThread().getName()+"-->"+tickNums--);
	}
	
	public static void main(String[] args) {
		//一份资源
		SynBlock03 web12306 = new SynBlock03();
		//多个代理
		new Thread(web12306,"xu").start();
		new Thread(web12306,"huang").start();
		new Thread(web12306,"li").start();
	}
	
	

}
