package com.xjj.java.thread02;

/**
 * 终止现成的两种方式
 * 1.线程正常进行，执行完毕
 * 2.外部干涉，加入标识
 * @author Administrator
 *
 */
public class TerminateThread implements Runnable{
	
	//加入标识，标记线程体是否可运行
	private boolean flag = true;
	
	private String name;
	
	public TerminateThread(String name) {
		super();
		this.name = name;
	}


	@Override
	public void run() {
		//关联标识，true-->运行，false-->停止
		int i= 0;
		while(flag) {
			System.out.println(name+":"+i++);
		}
	}
	
	//对外提供方法，改变标识
	public void terninate() {
		this.flag = false;
	}
	

	public static void main(String[] args) {
		
		TerminateThread terminateThread = new TerminateThread("xu");
		new Thread(terminateThread).start();
		
		for(int i=0;i<=99;i++) {
			System.out.println("main-->"+i);
			if(i==88) {
				terminateThread.terninate();//线程的终止
				System.out.println("terminateThread game over ");
			}
			
		}
	}

}
