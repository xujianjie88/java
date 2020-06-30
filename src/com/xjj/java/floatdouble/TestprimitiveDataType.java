package com.xjj.java.floatdouble;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 测试浮点数
 * @author Administrator
 *
 */
public class TestprimitiveDataType {
	
	public static void main(String[] args) {
	  float a = 3.14f;
	  double b = 6.28;
	  double c = 628E-2;//科学计数法，结果是 6.28
	  
	  System.out.println(c);
	  
	  //浮点数是不精确的，一定不能用来比较
	  float f = 0.1f;
	  double d = 1.0/10;
	  System.out.println(f==d);//结果为false
	  
	 
	  float a1 = 4112213f;
	  float b1 = a1+1;
	  System.out.println(a1==b1);
	  
	  //浮点数比较，用BigDecimal进行
	  BigDecimal bd = BigDecimal.valueOf(1.0);
	  bd = bd.subtract(BigDecimal.valueOf(0.1));
	  bd = bd.subtract(BigDecimal.valueOf(0.1));
	  bd = bd.subtract(BigDecimal.valueOf(0.1));
	  bd = bd.subtract(BigDecimal.valueOf(0.1));
	  bd = bd.subtract(BigDecimal.valueOf(0.1));
	  
	  System.out.println(bd);//0.5
	  
	  System.out.println(1.0-0.1-0.1-0.1-0.1-0.1);//0.5000000000000001
	  
	  BigDecimal bd2 = BigDecimal.valueOf(0.1);
	  BigDecimal bd3 = BigDecimal.valueOf(1.0/10.0);
	 
	  System.out.println(bd2.equals(bd3));//true
	  
	}

}
