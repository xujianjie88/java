package com.xjj.java.list;
/**
 * ÊÖÐ´µ×²ãµÄArrayList
 * @author Administrator
 *
 */
public class SxtArrayList {
	
	private Object[] elementData;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;
	
	public SxtArrayList() {
		elementData = new Object[DEFAULT_CAPACITY];
	}
	
	public SxtArrayList(int capacity) {
		elementData = new Object[capacity];
	}
	
	public void add(Object o) {
		elementData[size++] = o;
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
		SxtArrayList sxtArrayList = new SxtArrayList();
		sxtArrayList.add("A");
		sxtArrayList.add("B");
		System.out.println(sxtArrayList);
	}

	
	

}
