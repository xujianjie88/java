package com.xjj.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestReflect {
	
	/**
	 * 如何获取Class的实例
	 * @throws ClassNotFoundException 
	*/
	@Test
	public void test3() throws ClassNotFoundException {
		//1.调用运行时的.class属性
		Class class1 = Person.class;
		System.out.println(class1);
		
		Class class2 = String.class;
		System.out.println(class1);
		
		//2.通过运行时类的对象获取
		Person person = new Person();
		Class class3 = person.getClass();
		System.out.println(class3.getName());
		
		//3.通过Class的静态方法获取,通过此方式体会动态性，传参
		String name = "com.xjj.java.reflect.Person";
		Class class4 = Class.forName(name);
		System.out.println(class4.getName());
		
		//4.通过类的加载器加载
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class<?> loadClass = classLoader.loadClass(name);
		System.out.println(loadClass.getName());
	}
	
	
	
	
	/**
	 * java.lang.Class是所有反射的源头
	 *  
	  *  有了Class类的话可以执行以下操作:
	  *  1:首先创建运行时类的对象
	  *  2.可以获取对应运行时类的结构（属性、方法、构造器、内部类、父类、异常类、注解。。。。）
	  *  3.调用对应的运行时类的指定结构（属性、方法、构造器）
	  *  4.反射的运用，动态代理
	 * 
	 */
	@Test
	public void test2() {
		Person person = new Person();
		Class class1 = person.getClass();
		System.out.println(class1);
	}
	
	
	
    @Test
	public void test() throws Exception {
    	
    	Class clazz = Person.class;
    	
    	//1.创建clazz对应的运行时类Person的对象
    	Person person = (Person)clazz.newInstance();
    	System.out.println(person);
    	
    	//2.通过反射获取运行时类的属性,注意private属性会报NoSuchFieldException;
    	Field f1 = clazz.getField("name");
    	f1.set(person,"liudehua");
    	System.out.println(person);
    	
    	//2.1调用private必须设置setAccessible为true
    	Field f2 = clazz.getDeclaredField("age");//getDeclaredField
    	f2.setAccessible(true);//设置才可以访问
    	f2.set(person,20);
    	System.out.println(person);
    	
    	//2.2掉无参数方法
    	Method method = clazz.getMethod("show");
    	method.invoke(person);
    	
    	//2.3掉无参数方法
    	Method method2 = clazz.getMethod("display",String.class);
    	method2.invoke(person,"CHN");
	}

}
