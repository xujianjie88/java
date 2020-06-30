package com.xjj.java.lambda;
/**
 * lambda的推到+参数+返回值
 * @author Administrator
 *
 */
public class LambdaTuiDao2 {
	

	public static void main(String[] args) {
		//简化1，只关注函数/方法
		IInterest interest = (int a,int b)-> {
	       System.out.println("lambda-->:"+(a+b));	
	       return a+b;
		};
		interest.lambda(1, 1);
		
		//简化2，省略类型
		interest = (a,b)-> {
	       System.out.println("lambda-->:"+(a+b));	
	       return a+b;
		};
		interest.lambda(2, 3);
		
		//简化3，函数里是一行代码，直接写返回值
		interest = (a,b)-> a+b;
	
	}

}

interface IInterest{
	int lambda(int a, int b);
}

//外部类
class Interest implements IInterest{
	@Override
	public int lambda(int a,int b) {
       System.out.println("lambda-->:"+(a+b));	
       return a+b;
	}
	
}
