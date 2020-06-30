package com.xjj.java.staticproxy;

/**
 * 静态代理：
 * 接口：
 *   真实角色
 *   代理角色
 * 
 * @author Administrator
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		//对比new Thread(代理对象).start()
		new MerryCompany(new You()).happyMerry();
		
	}

}

interface Merry{
	void happyMerry();
}

class You implements Merry{

	@Override
	public void happyMerry() {
		System.out.println("你和嫦娥结婚了");
	}
	
}


class MerryCompany implements Merry{

	//真实角色
	private Merry target;
	
	public MerryCompany(Merry target) {
		this.target = target;
	}
	

	@Override
	public void happyMerry() {
		ready();
		this.target.happyMerry();
		after();
	}

	private void after() {
		System.out.println("结束。。。");
	}

	private void ready() {
		System.out.println("准备。。。");
	}
	
}


