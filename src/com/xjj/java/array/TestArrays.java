package com.xjj.java.array;
/**
 * 数组的练习
 * @author Administrator
 *
 */

public class TestArrays {
	
	 public static void main(String[] args) {
		 //方式一 
		 String[] str = new String[10];//创建一个长度为10的String 类型数组。
		 str[0] = "aa";
		 str[1] = "bb";
		 str[2] = "cc";
		 for(int i=0;i<str.length;i++) {
			 System.out.println("========方式一==========");
			 System.out.println(str[i]);
		 }
		 //方式二
		 String str2[] = {"张三","李四"};
		 for(int i=0;i<str2.length;i++) {
			 System.out.println("========方式二==========");
			 System.out.println(str2[i]);
		 }
		 //方式三
		 String[] arr = new String[10];

	}

}
