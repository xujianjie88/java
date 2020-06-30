package com.xjj.java.lambda;
/**
 * lambda的推到+参数
 * @author Administrator
 *
 */
public class LambdaTuiDao3 {
	

	public static void main(String[] args) {
		//简化1，只关注函数/方法
		ILike like = (int a)-> {
		       System.out.println("lambda-->"+a);		
		};
		like.lambda(100);
		
		//简化2,去掉类型
		like = (a)-> {
		       System.out.println("lambda-->"+a);		
		};
		like.lambda(200);
		
		//简化3,1个参数可以省略括号
		like = a-> {
		       System.out.println("lambda-->"+a);		
		};
		like.lambda(300);
		
		//简化4,函数是一句话的话，可以省略花括号；
		like = a->System.out.println("lambda-->"+a);		
		like.lambda(400);
	}

}

interface ILike{
	void lambda(int a);
}

//外部类
class Like implements ILike{
	@Override
	public void lambda(int a) {
       System.out.println("lambda-->"+a);		
	}
	
}
