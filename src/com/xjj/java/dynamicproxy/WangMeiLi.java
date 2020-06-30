package com.xjj.java.dynamicproxy;

public class WangMeiLi implements Girl{

	@Override
	public void date() {
		System.out.println("王美丽：跟你约会很开心。。。。");
	}

	@Override
	public void watchMovie() {
		System.out.println("王美丽：这电影我不喜欢看。。。。");
	}

}
