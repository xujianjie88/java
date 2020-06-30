package com.xjj.java.thread;
/**
 * 创建线程的方式一：
 * 1.继承thread，重写run方法
 * 2.启动：创建子类对象，调用start启动
 * @author Administrator
 *
 */
public class TestThread extends Thread{
	
	/**
	 * 线程的入口点
	 */
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
		  System.out.println("一边听歌。。。");
		}
	}
	
	public static void main(String[] args) {
		
		TestThread thread = new TestThread();
		//启动
		thread.start();//不保证立即执行，由cpu调用
		//普通方法的调用
		//thread.run();
		for(int i=0;i<20;i++) {
			  System.out.println("一边coding。。。");
		}
	}

}
