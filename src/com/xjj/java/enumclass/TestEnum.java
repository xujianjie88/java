package com.xjj.java.enumclass;
/**
 * 测试枚举
 * @author Administrator
 *
 */
public class TestEnum {
	
	public static void main(String[] args) {
		System.out.println(Season.SPRING);
		
		Season aSeason = Season.AUTUMN;
		
		switch (aSeason) {
		case AUTUMN:
			System.out.println("春天来了");
			break;
		default:
			break;
		}
	}
	
	enum Season{
		SPRING,SUMMER,AUTUMN,WINTER
	}
	enum Week{
		星期一,星期二,星期三,星期四,星期五
	}

}
