package com.xjj.java.array;
/**
 * �������ϰ
 * @author Administrator
 *
 */

public class TestArrays {
	
	 public static void main(String[] args) {
		 //��ʽһ 
		 String[] str = new String[10];//����һ������Ϊ10��String �������顣
		 str[0] = "aa";
		 str[1] = "bb";
		 str[2] = "cc";
		 for(int i=0;i<str.length;i++) {
			 System.out.println("========��ʽһ==========");
			 System.out.println(str[i]);
		 }
		 //��ʽ��
		 String str2[] = {"����","����"};
		 for(int i=0;i<str2.length;i++) {
			 System.out.println("========��ʽ��==========");
			 System.out.println(str2[i]);
		 }
		 //��ʽ��
		 String[] arr = new String[10];

	}

}
