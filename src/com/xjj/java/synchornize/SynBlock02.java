package com.xjj.java.synchornize;
/**
 * 线程安全,同步快
 * @author Administrator
 *
 */
public class SynBlock02 {
	
	public static void main(String[] args) {
		
		//账户
		SynAccount account = new SynAccount(1000, "结婚");
	    SynDrawing you = new SynDrawing(account, 80, "可悲的你");
	    SynDrawing wife = new SynDrawing(account, 90, "开心的她");
	    you.start();
	    wife.start();
	}

}

class SynAccount {
	int money;//金额
	String name;//名称
	public SynAccount(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}
}

class SynDrawing extends Thread{
	
	SynAccount account;//取钱的账户
	int drawingMoney;//取得钱数
	int packetTotal;//钱包的总数
	
	public SynDrawing(SynAccount account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		test();
	}
	
	public void test() {
		//注意多线程时，这句话很重要 ，提高性能
		if(account.money<=0) {
			return;
		}
		synchronized (account) {
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
}
