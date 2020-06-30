package com.xjj.java.lambda;
/**
 * 测试线程的lambda
 * @author Administrator
 *
 */
public class TestThreadLambda {
	
	//静态内部类
	static class Test implements Runnable{
		@Override
		public void run() {
		   for(int i=0;i<20;i++) {
			  System.out.println("一边听歌。。。");
			}
		}
		
	}
	
	public static void main(String[] args) {
		//new Thread(new Test()).start();
		
		//局部内部类
		class Test2 implements Runnable{
			@Override
			public void run() {
			   for(int i=0;i<20;i++) {
				  System.out.println("一边听歌。。。");
				}
			}
		}
		new Thread(new Test2()).start();
		
		//匿名内部类，必须借助接口或者父类
		new Thread(new Runnable() {
			@Override
			public void run() {
				 for(int i=0;i<20;i++) {
					  System.out.println("一边听歌。。。");
					}
			}
		}).start();
		
		
		//jdk8,简化lambda,只需要关注方法体，jdk会自动推到，注意接口必须是一个方法才行
		new Thread(()-> {
				 for(int i=0;i<20;i++) {
					  System.out.println("一边听歌。。。");
					}
		}).start();
		
		
    }

}
