package com.xjj.java.synchornizelizi;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class HappyCinema02 {
	
	public static void main(String[] args) {
		
		List<Integer> avaliable = new ArrayList<>();
		avaliable.add(1);
		avaliable.add(2);
		avaliable.add(3);
		avaliable.add(5);
		avaliable.add(6);
		HICinema cinema = new HICinema(avaliable, "许建杰影院");
		
		//顾客需要的位置
		List<Integer> c1 = new ArrayList<>();
		c1.add(1);
		c1.add(2);
		c1.add(3);
		
		List<Integer> c2 = new ArrayList<>();
		c2.add(1);
		c2.add(2);
		c2.add(3);
		
//		c2.add(5);
//		c2.add(6);
		
		new Thread(new HiCustomer(cinema,c1),"小许").start();
		new Thread(new HiCustomer(cinema, c2),"小许").start();
	}
}

class HiCustomer implements Runnable{
	
	HICinema cinema;
	List<Integer> seats;
	public HiCustomer(HICinema cinema,List<Integer> seats) {
		this.cinema = cinema;
		this.seats = seats;
	}
	@Override
	public void run() {
        synchronized (cinema) {
        	boolean flag = cinema.buyTicket(seats);
    		if(flag) {
    			System.out.println("出票成功"+Thread.currentThread().getName()+"-->位置为"+seats);
    		}else {
    			System.out.println("出票失败"+Thread.currentThread().getName()+"-->位置不够");
    		}
		}
	}
}

class HICinema{
	List<Integer> avaliable;//可用位置
	String name;//名称
	public HICinema(List<Integer> avaliable, String name) {
		super();
		this.avaliable = avaliable;
		this.name = name;
	}
	
	//购票
	public boolean buyTicket(List<Integer> seats) {
		System.out.println("可用的位置为"+avaliable);
		List<Integer> copyList = new ArrayList<>();
		copyList.addAll(avaliable);
		//相减
		copyList.removeAll(seats);
		
		if(avaliable.size()-copyList.size()!=seats.size()) {
			return false;
		}
		
		avaliable = copyList;
		return true;
	}
}
