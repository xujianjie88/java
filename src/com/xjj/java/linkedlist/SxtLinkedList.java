package com.xjj.java.linkedlist;

import java.util.LinkedList;

/**
 * 自定义一个链表
 * @author Administrator
 *
 */
public class SxtLinkedList {
	
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
		SxtLinkedList sxtLinkedList = new SxtLinkedList();
		sxtLinkedList.add("a");
		sxtLinkedList.add("b");
		sxtLinkedList.add("c");
		System.out.println(sxtLinkedList);

		LinkedList<Object> objects = new LinkedList<>();
	}

}
