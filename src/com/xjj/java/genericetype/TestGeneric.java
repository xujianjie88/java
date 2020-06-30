package com.xjj.java.genericetype;
/**
 * 测试泛型
 * @author Administrator
 *
 */
public class TestGeneric {
	
	public static void main(String[] args) {
		MyCollection<String> myCollection = new MyCollection<String>();
		myCollection.set("许好人", 0);
//		myCollection.set(8888,1);
		
		String name = myCollection.get(0);
//		Integer num =  (Integer)myCollection.get(1);
		
		System.out.println(name);
//     	System.out.println(num);
	}

}
