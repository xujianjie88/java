package com.xjj.java.zaixianliaotian;
/**
 * 加入多线程 实现双向交流 模拟在线交流
 * @author Administrator
 *
 */
public class TalkStudent {
	
	public static void main(String[] args) {
		new Thread(new TalkSend03(7777,"localhost",9999)).start();//发送
		
		new Thread(new TalkServer03(8888)).start();//接收
	}

}
