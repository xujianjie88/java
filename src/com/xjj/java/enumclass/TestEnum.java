package com.xjj.java.enumclass;
/**
 * ����ö��
 * @author Administrator
 *
 */
public class TestEnum {
	
	public static void main(String[] args) {
		System.out.println(Season.SPRING);
		
		Season aSeason = Season.AUTUMN;
		
		switch (aSeason) {
		case AUTUMN:
			System.out.println("��������");
			break;
		default:
			break;
		}
	}
	
	enum Season{
		SPRING,SUMMER,AUTUMN,WINTER
	}


}
