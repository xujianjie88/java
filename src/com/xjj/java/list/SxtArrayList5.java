package com.xjj.java.list;
/**
 * 手写底层的ArrayList
 * 测试remove方法
 *
 * @author Administrator
 *
 */
public class SxtArrayList5<E> {
	
	private Object[] elementData;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;
	
	public SxtArrayList5() {
		elementData = new Object[DEFAULT_CAPACITY];
	}
	
	public SxtArrayList5(int capacity) {
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
	
	//remove移除操作
	public void remove(E element) {
		
		for(int i=0;i<size;i++) {
			if(element.equals(get(i))) {//容器的中用的所有比较操作用的都是equals而不是==
				//移除该元素
				
			}
		}
		
	}
	
	public void remove(int index) {
		//删除c,abcdef-->adbef
		//第一个参数：拷贝的数组;第二个参数：拷贝的开始位置；第三个参数：存放的地方；第四个参数：存放的开始位置；拷贝的个数
		int moveNum = elementData.length-index-1;
		if(moveNum>0) {
			System.arraycopy(elementData, index+1, elementData, index, moveNum);
		}
		elementData[--size] = null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}else {
			return false;
		}
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
		SxtArrayList5<Integer> sxtArrayList = new SxtArrayList5<Integer>();
		for(int i=0;i<40;i++){
			sxtArrayList.add(i);
		}
		System.out.println(sxtArrayList);
		//System.out.println(sxtArrayList.get(10));
		
		sxtArrayList.remove(3);
		sxtArrayList.remove(10);
		System.out.println(sxtArrayList);
		System.out.println(sxtArrayList.isEmpty());
	}

	
	

}
