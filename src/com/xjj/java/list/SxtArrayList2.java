package com.xjj.java.list;
/**
 * 手写底层的ArrayList
 * 增加泛型
 * @author Administrator
 *
 */
public class SxtArrayList2<E> {
	
	private Object[] elementData;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;
	
	public SxtArrayList2() {
		elementData = new Object[DEFAULT_CAPACITY];
	}
	
	public SxtArrayList2(int capacity) {
		elementData = new Object[capacity];
	}
	
	public void add(E e) {
		elementData[size++] = e;
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("[");
		for(int i=0;i<size;i++) {
			stringBuffer.append(elementData[i]+",");
		}
		stringBuffer.setCharAt(stringBuffer.length()-1, ']');
		return stringBuffer.toString();
	}
	
	public static void main(String[] args) {
		SxtArrayList2<Integer> sxtArrayList = new SxtArrayList2<Integer>();
		sxtArrayList.add(1);
		sxtArrayList.add(1);
		System.out.println(sxtArrayList);
	}

	
	

}
