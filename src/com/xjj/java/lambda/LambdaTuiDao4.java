package com.xjj.java.lambda;
/**
 * lambda的推到，简化线程
 * @author Administrator
 *
 */
public class LambdaTuiDao4 {
	

	public static void main(String[] args) {
		new Thread(()->{
		for(int i=0;i<20;i++) {
			  System.out.println("一边听歌。。。");
			}
		}) .start();
		
		for(int i=0;i<20;i++) {
			  System.out.println("lambda秒呀。。。");
			}
	}

}
