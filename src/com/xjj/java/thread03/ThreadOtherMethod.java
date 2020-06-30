package com.xjj.java.thread03;
/**
 * 其他方法
 * @author Administrator
 *
 */
public class ThreadOtherMethod {
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().isAlive());
	   
		//设置名称，真实角色+代理角色
		MyInfo myInfo = new MyInfo("战斗机");
	    Thread thread = new Thread(myInfo);
	    thread.setName("公鸡");//设置线程的名字
	
	    thread.start();
	    System.out.println(thread.isAlive());
	    
	}

}

class MyInfo implements Runnable{

	private String name;
	
	public MyInfo(String name) {
		super();
		this.name = name;
	}


	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->"+name);
	}
	
}
