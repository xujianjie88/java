package com.xjj.java.thread03;
/**
 * 守护线程，是为用户线程服务的，jvm停止是不需要守护线程执行完毕
 * 默认都是用户线程，jvm等到用户线程停止才会停止
 * @author Administrator
 *
 */
public class TestDaemon {
	
     public static void main(String[] args) {
		 God god = new God();
		 You you = new You();
//		 new Thread(god).start();
//		 new Thread(you).start();
		 
		Thread thread = new Thread(god);
		thread.setDaemon(true);//设置为守护线程
		thread.start();
		
		new Thread(you).start();
	 }

}

class You extends Thread{
	
	@Override
	public void run() {
		for(int i=1;i<=365*100;i++) {
			System.out.println("happy life");
		}
		System.out.println("oooo....");
	}
	
}

class God extends Thread{

	@Override
	public void run() {
		for(;true;) {
			System.out.println("bless you");
		}
	}
}
