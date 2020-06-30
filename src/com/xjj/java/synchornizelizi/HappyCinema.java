package com.xjj.java.synchornizelizi;


public class HappyCinema {
	
	public static void main(String[] args) {
		Cinema cinema = new Cinema(10, "许建杰影院");
		new Thread(new Customer(cinema, 2),"许").start();
		new Thread(new Customer(cinema, 2),"姚").start();
	}
}

class Customer implements Runnable{
	
	Cinema cinema;
	int seats;
	public Customer(Cinema cinema, int seats) {
		this.cinema = cinema;
		this.seats = seats;
	}
	@Override
	public void run() {
		boolean flag = cinema.buyTicket(seats);
		if(flag) {
			System.out.println("出票成功"+Thread.currentThread().getName()+"-->位置为"+seats);
		}else {
			System.out.println("出票成功"+Thread.currentThread().getName()+"-->位置不够");
		}
	}
	
}

class Cinema{
	int avaliable;//可用位置
	String name;//名称
	public Cinema(int avaliable, String name) {
		super();
		this.avaliable = avaliable;
		this.name = name;
	}
	
	//购票
	public boolean buyTicket(int seats) {
		System.out.println("可用的位置为"+avaliable);
		if(seats>avaliable) {
			return false;
		}
		avaliable-=seats;
		return true;
	}
}
