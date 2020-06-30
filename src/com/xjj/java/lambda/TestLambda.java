package com.xjj.java.lambda;
/**
 * 函数式的编程
 * @author Administrator
 *
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.print.attribute.standard.PrinterLocation;

public class TestLambda {
	
	//流是如何工作的
	public static void main(String[] args) {
		//1.
		List<String> strList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		strList.stream()
		       .filter(s->s.startsWith("a"))
		       .map(String::toUpperCase)
		       .sorted()
		       .forEach(System.out::println);
		
		System.out.println("2.===========");
		
		//2.在集合上调用stream()方法会返回一个普通的 Stream 流。
		//但是, 您大可不必刻意地创建一个集合，再通过集合来获取 Stream 流
		Stream.of("a1", "a2", "a3")
	    .findFirst()
	    .ifPresent(System.out::println); 
		
		System.out.println("3.===========");
		 //3.IntStreams.range()方法还可以被用来取代常规的 for 循环, 如下所示：
	     //相当于 for (int i = 1; i < 4; i++) {}
		 IntStream.range(1,4).
		   forEach(System.out::println);
		 
		 System.out.println("4.===========");
		 //4.原始类型流使用其独有的函数式接口，例如IntFunction代替Function，IntPredicate代替Predicate。
         //原始类型流支持额外的终端聚合操作，sum()以及average()，如下所示：
		 Arrays.stream(new int[] {1, 2, 3})
		    .map(n -> 2 * n + 1) // 对数值中的每个对象执行 2*n + 1 操作
		    .average() // 求平均值
		    .ifPresent(System.out::println);  // 如果值不为空，则输出
		 
		  System.out.println("5.===========");
		 //5.但是，偶尔我们也有这种需求，需要将常规对象流转换为原始类型流，这个时候，中间操作 mapToInt()，
		 //mapToLong() 以及mapToDouble就派上用场了：
		 Stream.of("a1", "a2", "a3")
		    .map(s -> s.substring(1)) // 对每个字符串元素从下标1位置开始截取
		    .mapToInt(Integer::parseInt) // 转成 int 基础类型类型流
		    .max() // 取最大值
		    .ifPresent(System.out::println);  // 不为空则输出
		 
		 System.out.println("6.流装换成对象流===========");
		 //6.如果说，您需要将原始类型流装换成对象流，您可以使用 mapToObj()来达到目的：
		 IntStream.range(1,4)
		          .mapToObj(i->"a"+i)
		          .forEach(System.out::println);
		 
		 System.out.println("7.将双精度流首先转换成 int 类型流===========");
		 //7.下面是一个组合示例，我们将双精度流首先转换成 int 类型流，然后再将其装换成对象流：
		 Stream.of(1.0,2.0,3.0)
		       .mapToInt(Double::intValue)
		       .mapToObj(i->"a"+i)
		       .forEach(System.out::println);
	         
	}
	

}
