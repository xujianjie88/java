package com.xjj.java.genericetype;


public class MyCollection<E> {
	
	Object[] obj = new Object[5];
	
	public void set(E e,int index) {
	   obj[index]=e;
	}
	
	public E get(int index) {
		return (E)obj[index];
	}

}
