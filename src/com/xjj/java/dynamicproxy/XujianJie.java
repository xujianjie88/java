package com.xjj.java.dynamicproxy;

public class XujianJie {
	
	public static void main(String[] args) {
		//隔壁有个王美丽
		Girl girl = new WangMeiLi();
		//他有个庞大的家庭，想要跟他约会必须得他家人同意
		WangMeiLiProxy family = new WangMeiLiProxy(girl);
		//有一次约会，碰到了她妈妈，我征得了她妈妈的同意
		Girl mother = (Girl) family.getProxyInstance();
		//通过她妈妈这个代理才能和王美丽约会
		mother.date();
		//分割线
		System.out.println("--------");
		mother.watchMovie();
		
	}

}
