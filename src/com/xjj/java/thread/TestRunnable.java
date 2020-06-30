package com.xjj.java.thread;
/**
 * 创建线程的方式二：
 * 1.实现runnable，重写run方法
 * 2.启动：创建实现类对象+Thread对象+调用start启动
 * @author Administrator
 *避免继承的局限性，优先使用接口
 *方便资源的共享
 */
public class TestRunnable implements Runnable{
	
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
//		//创建实现类对象
//		TestRunnable testRunnable = new TestRunnable();
//		//创建代理对象
//		Thread t = new Thread(testRunnable);
//		//启动
//		t.start();//不保证立即执行，由cpu调用
		
		//如果一个对象只使用一次，那么可以使用匿名
		new Thread(new TestRunnable()).start();
		
		for(int i=0;i<20;i++) {
			  System.out.println("一边coding。。。");
		}
	}

}
