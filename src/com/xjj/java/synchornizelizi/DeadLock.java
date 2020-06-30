package com.xjj.java.synchornizelizi;
/**
 * 死锁，过多的同步可能造成相互不释放资源
 * 
 * 从而相互等待，一般发生于同步中持有多个对象的锁
 * 
 * @author Administrator
 *
 */
public class DeadLock {
  public static void main(String[] args) {
	MarkUp markUp1 = new MarkUp(1, "刘德华");
	MarkUp markUp2 = new MarkUp(0, "张学友");
	markUp1.start();
	markUp2.start();
}
}

//口红
class Lipstick{
	
}
//镜子
class Mirror{
	
}
//化妆
class MarkUp extends Thread{
	
	static Lipstick lipstick = new Lipstick();
	static Mirror mirror = new Mirror();
	
	//选择
	int choice;
	//名字
	String girl;	
	public MarkUp(int choice, String girl) {
		super();
		this.choice = choice;
		this.girl = girl;
	}


	@Override
	public void run() {
		//化妆
		markUp();
	}
	
	//相互持有对方的对象锁--》可能死锁
	public void markUp(){
		if(choice==0) {
			synchronized (lipstick) {//获得口红的锁
				System.out.println(this.girl+"获得口红");
			}
			//1秒后获得镜子的锁
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (mirror) {
				System.out.println(this.girl+"照镜子");
			}
		}else {
			synchronized (mirror) {//获得镜子的锁
				System.out.println(this.girl+"照镜子");
			}
			//2秒后获得口红的锁
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (lipstick) {
				System.out.println(this.girl+"照镜子");
			}
			
		}
	}
}

