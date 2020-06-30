package com.xjj.java.synchornize;
/**
 * 银行取钱
 * @author Administrator
 *
 */
public class Unsafe {
	
	public static void main(String[] args) {
		
		//账户
		Account account = new Account(100, "结婚");
	    Drawing you = new Drawing(account, 80, "可悲的你");
	    Drawing wife = new Drawing(account, 90, "开心的她");
	    you.start();
	    wife.start();
	}

}

class Account {
	int money;//金额
	String name;//名称
	public Account(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}
}

class Drawing extends Thread{
	
	Account account;//取钱的账户
	int drawingMoney;//取得钱数
	int packetTotal;//钱包的总数
	
	public Drawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		
		if(account.money-drawingMoney<0) {
			return;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		account.money-=drawingMoney;
		packetTotal+=drawingMoney;
		System.out.println(this.getName()+"-->账户余额"+account.money);
		System.out.println(this.getName()+"-->口袋的钱"+packetTotal);
	}
}
