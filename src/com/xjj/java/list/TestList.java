package com.xjj.java.list;

import java.util.ArrayList;
import java.util.List;
/**
 * 测试list集合之间的操作
 * @author Administrator
 *
 */
public class TestList {
	
	public static void main(String[] args) {
		
		test02();
	}
	
	//测试list的常用的操作
	public static void test01() {
		List<String> strList = new ArrayList<>();
		strList.add("aa");
		strList.add("bb");
		
		List<String> list = new ArrayList<>();
		list.add("bb");
		list.add("cc");
		list.add("dd");
		
		//1.把容器list的元素放进strList
		//strList.addAll(list);
		//2.strList去掉在集合list中的元素
		//strList.removeAll(list);//aa
		//3.取交集
		//strList.retainAll(list);//bb
		//4.false
		System.out.println(strList.containsAll(list));
		//5.清空集合
		strList.clear();
		System.out.println(strList.size());
		System.out.println(strList.isEmpty());
		
		for(String str:strList) {
			System.out.println(str);
		}
	}
	
	//测试ArrayList的常用的方法,底层的实现是数组，默认容量是10，当容量超出时,新建一个数组，
	//把原来的数组拷贝过去，10+10/2
	public static void test02() {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		
		//在某个位置添加元素
		list.add(2, "D");
		
		//修改某个位置的元素
		//list.set(3, "许好人");
		
		
		list.add("B");
		list.add("C");
		
		System.out.println(list);
		
		//测试list的索引
		System.out.println(list.indexOf("B"));
		System.out.println(list.lastIndexOf("B"));
	}

}
