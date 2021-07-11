package com.xjj.java.genericetype;

import com.xjj.java.genericetype.ext.Person;
import com.xjj.java.genericetype.ext.Women;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试泛型
 * @author Administrator
 *
 */
public class TestGeneric {
	
	public static void main(String[] args) {
		MyCollection<String> myCollection = new MyCollection<String>();
		myCollection.set("许好人", 0);
//		myCollection.set(8888,1);
		
		String name = myCollection.get(0);
//		Integer num =  (Integer)myCollection.get(1);
		
		System.out.println(name);
//     	System.out.println(num);
	}

	/**
	 *1、 测试泛型方法
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
		//测试静态泛型方法
		convertArrayToList2(strArr);
	}

	/**
	 * 2、测试泛型的通配符
	 */
	@Test
    public void testTongPeiFu(){
		List<Integer> integers = Arrays.asList(1,2,3);
		List<String>  strings = Arrays.asList("AA","BB","CC");
		printList(integers);
		printList(strings);
	}

	/**
	 * 3、测试有限定条件的泛型
	 *  ? extends Person:<=Person
	 *  ? super Person:>=Person
	 */
	public void testLimitConditionGeneric(){
		List<? extends Person> list1 = null;
		List<? super Person> list2 = null;

		List<Women> list3 = new ArrayList<>();
		List<Person> list4 = new ArrayList<>();
		List<Object> list5 = new ArrayList<>();
		//? extends，代表?类型是要<=Person
		list1 = list3;
		list1 = list4;
 //		list1 = list5;
		//读取数据
		Person person = list1.get(0);
		//编译不通过
//		list1.add(new Women());

		//? super，代表?类型是要>=Person
//		list2 = list3;
		list2 = list4;
		list2 = list5;
		//读取数据
		Object object = list2.get(0);
		//
		list2.add(new Person());
		list2.add(new Women());


	}


	/**
	 * List<E>前面的<E>是为了告诉编译器这是一个泛型而不是一个E类
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
	 * 泛型方法是可以声明为静态的。原因：泛型参数是调用方法时确定的，并非实例化类时确定的
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
	 * 泛型的通配符
	 *注意：不能添加数据，既不能list.add(),可以add(null)
	 * @param list
	 */
	public void printList(List<?> list){
		for (Object o : list) {
			System.out.println(o);
		}
	}



}
