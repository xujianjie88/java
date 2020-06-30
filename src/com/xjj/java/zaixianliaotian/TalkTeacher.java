package com.xjj.java.zaixianliaotian;

public class TalkTeacher {
	
	public static void main(String[] args) {
		new Thread(new TalkServer03(9999)).start();//½ÓÊÕ
		
		new Thread(new TalkSend03(5555,"localhost",8888)).start();//·¢ËÍ
	}

}
