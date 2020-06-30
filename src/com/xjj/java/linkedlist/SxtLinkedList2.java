package com.xjj.java.linkedlist;
/**
 * 自定义一个链表
 * 
 * 测试get方法
 * @author Administrator
 *
 */
public class SxtLinkedList2 {
	
	private Node first;
	private Node last;
	
	private int size;
	
	public void add(Object object) {
		Node node = new Node(object);
		if(first==null) {
//			node.previous=null;
//			node.next=null;
			first=node;
			last=node;
		}else {
			node.previous = last;
			node.next = null;
			
			last.next = node;
			last = node;
		}
		
	}
	
	public Object get(int index) {
		Node temp = first;
		for(int i=0;i<index;i++) {
			temp = temp.next;
		}
		return temp.element;
	}
	
	@Override
	public String toString() {
		//[a,b,c] first=a,last=c
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node temp = first;
		while (temp!=null) {
		   sb.append(temp.element+",");
           temp = temp.next;
		}
		sb.setCharAt(sb.length()-1,']');
		return sb.toString();
	}
	
	public static void main(String[] args) {
		SxtLinkedList2 sxtLinkedList = new SxtLinkedList2();
		sxtLinkedList.add("a");
		sxtLinkedList.add("b");
		sxtLinkedList.add("c");
		System.out.println(sxtLinkedList);
		System.out.println(sxtLinkedList.get(1));
	}

}
