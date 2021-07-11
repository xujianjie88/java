package com.xjj.java.genericetype;

import com.xjj.java.genericetype.ext.Person;
import com.xjj.java.genericetype.ext.Women;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ���Է���
 * @author Administrator
 *
 */
public class TestGeneric {
	
	public static void main(String[] args) {
		MyCollection<String> myCollection = new MyCollection<String>();
		myCollection.set("�����", 0);
//		myCollection.set(8888,1);
		
		String name = myCollection.get(0);
//		Integer num =  (Integer)myCollection.get(1);
		
		System.out.println(name);
//     	System.out.println(num);
	}

	/**
	 *1�� ���Է��ͷ���
	 */
	@Test
	public void testGenericMethod(){
		String[] strArr = new String[]{"AA","BB","CC"};
		List<String> strings = convertArrayToList(strArr);
		for (String string : strings) {
			System.out.println(string);
		}
		Integer[] integers = new Integer[]{1,2};
		List<Integer> integerList = convertArrayToList(integers);
		for (Integer integer : integerList) {
			System.out.println(integer);
		}
		//���Ծ�̬���ͷ���
		convertArrayToList2(strArr);
	}

	/**
	 * 2�����Է��͵�ͨ���
	 */
	@Test
    public void testTongPeiFu(){
		List<Integer> integers = Arrays.asList(1,2,3);
		List<String>  strings = Arrays.asList("AA","BB","CC");
		printList(integers);
		printList(strings);
	}

	/**
	 * 3���������޶������ķ���
	 *  ? extends Person:<=Person
	 *  ? super Person:>=Person
	 */
	public void testLimitConditionGeneric(){
		List<? extends Person> list1 = null;
		List<? super Person> list2 = null;

		List<Women> list3 = new ArrayList<>();
		List<Person> list4 = new ArrayList<>();
		List<Object> list5 = new ArrayList<>();
		//? extends������?������Ҫ<=Person
		list1 = list3;
		list1 = list4;
 //		list1 = list5;
		//��ȡ����
		Person person = list1.get(0);
		//���벻ͨ��
//		list1.add(new Women());

		//? super������?������Ҫ>=Person
//		list2 = list3;
		list2 = list4;
		list2 = list5;
		//��ȡ����
		Object object = list2.get(0);
		//
		list2.add(new Person());
		list2.add(new Women());


	}


	/**
	 * List<E>ǰ���<E>��Ϊ�˸��߱���������һ�����Ͷ�����һ��E��
	 * @param eArr
	 * @param <E>
	 * @return
	 */
	public <E> List<E> convertArrayToList(E[] eArr) {
		List<E> list = new ArrayList<>();
		for (E e : eArr) {
			list.add(e);
		}
		return list;
	}

	/**
	 * ���ͷ����ǿ�������Ϊ��̬�ġ�ԭ�򣺷��Ͳ����ǵ��÷���ʱȷ���ģ�����ʵ������ʱȷ����
	 * @param eArr
	 * @param <E>
	 * @return
	 */
	public static <E> List<E> convertArrayToList2(E[] eArr) {
		List<E> list = new ArrayList<>();
		for (E e : eArr) {
			list.add(e);
		}
		return list;
	}

	/**
	 * ���͵�ͨ���
	 *ע�⣺����������ݣ��Ȳ���list.add(),����add(null)
	 * @param list
	 */
	public void printList(List<?> list){
		for (Object o : list) {
			System.out.println(o);
		}
	}



}
