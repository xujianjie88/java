package com.xjj.java.map;

import java.util.Collections;

/**
 * 底层代码实现：Hashmap的底层是哈希表=数组+链表
 * 自定义Hashmap
 * @author Administrator
 *
 */
public class SxtHashMap {
	
    Node[] table;//位桶数组 bucket array
    int size;
    
    Node iterList = null;//正在遍历的是最后一个元素
    
    
   public SxtHashMap() {
	   table = new Node[16];//长度一般定义成2的整数幂
   }
   
   public void put(Object key,Object value) {
	   //定义了新的节点对象
	   Node newNode = new Node();
	   newNode.hash=myHash(key.hashCode(),table.length);
	   newNode.key = key;
	   newNode.value = value;
	   newNode.next = null;
	   
	   Node temp = table[newNode.hash];
	   if(temp==null) {
		   //此处数组元素为空，则直接存放节点数
		   table[newNode.hash] = newNode;
	   }else {
		   //此处数组元素不为空，则遍历对应的链表
		   while(temp!=null) {
			   //判断key如果重复，则覆盖
			   if(temp.key.equals(key)) {
				   System.out.println("key重复了");
				   temp.value = value;//只需要覆盖值就可以了，hash,next等不要变
				   return;
			   }else {
				   //key不重复
				   iterList = temp;
				   temp = temp.next;
			   }
		   }
		   iterList = newNode;
	   }
   }
   
   public static void main(String[] args) {
	SxtHashMap sxtHashMap = new SxtHashMap();
	sxtHashMap.put(10, "aa");
	sxtHashMap.put(20, "bb");
	sxtHashMap.put(30, "cc");
	System.out.println(sxtHashMap);
   }
   
   
   public int myHash(int v,int length) {
	   System.out.println("hash in myHash"+(v&(length-1)));//直接位与运算,效率高
	   System.out.println("hash in myHash"+(v%(length-1)));//取余，效率低
	   return v&(length-1);
   }
	
	
	

}
