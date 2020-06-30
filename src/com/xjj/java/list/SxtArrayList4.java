package com.xjj.java.list;
/**
 * 手写底层的ArrayList
 * 测试下标越界,set，get方法
 *
 * @author Administrator
 *
 */
public class SxtArrayList4<E> {
	
	private Object[] elementData;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;
	
	public SxtArrayList4() {
		elementData = new Object[DEFAULT_CAPACITY];
	}
	
	public SxtArrayList4(int capacity) {
		if(capacity<0) {
			throw new RuntimeException("容器的容量不能为负数"+capacity);
		}else if(capacity==0){
			elementData = new Object[DEFAULT_CAPACITY];
		}else {
			elementData = new Object[capacity];
		}
		
	}
	
	public void add(E e) {
		//什么时候扩容
		if(elementData.length==size) {
			//怎么扩容
			Object[] newArray = new Object[elementData.length+(elementData.length>>1)];//10+10/2
		    System.arraycopy(elementData, 0, newArray, 0, elementData.length);
		    elementData = newArray;
		}
		elementData[size++] = e;
	}
	
	//获取对应的下标的值
	public E get(int index) {
		checkRange(index);
		return (E)elementData[index];
	}
	
	//为对应的下标设值
	public void set(E element,int index) {
		checkRange(index);
		elementData[index]=element;
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
	
	public void checkRange(int index) {
		//判断索引是否越界
		if(index<0||index>size-1) {
			throw new RuntimeException("索引不合法!"+index);
		}
	}
	
	public static void main(String[] args) {
		SxtArrayList4<Integer> sxtArrayList = new SxtArrayList4<Integer>();
		for(int i=0;i<40;i++){
			sxtArrayList.add(i);
		}
		System.out.println(sxtArrayList);
		System.out.println(sxtArrayList.get(10));
		
		sxtArrayList.set(100000, 10);
		System.out.println(sxtArrayList);
		
		//数组下标越界
		sxtArrayList.set(11, -10);
		sxtArrayList.get(-1);
		
	}

	
	

}
