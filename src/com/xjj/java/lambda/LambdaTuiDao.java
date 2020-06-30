package com.xjj.java.lambda;
/**
 * lambda的推到
 * @author Administrator
 *
 */
public class LambdaTuiDao {
	
	//静态内部类
	static class Love2 implements ILove{
		@Override
		public void lambda() {
	      System.out.println("我喜欢学习lambda2");		
		}
		
	}
	
	public static void main(String[] args) {
		
		ILove love = new Love();
		love.lambda();
		
		love = new Love2();
		love.lambda();
		//匿名内部类
		love = new ILove() {
			@Override
			public void lambda() {
				  System.out.println("我喜欢学习lambda3");		
			}
		};
		love.lambda();
		
		//lambda简化
		love = ()-> {
		      System.out.println("我喜欢学习lambda4");		
		};
		love.lambda();
		
	}

}

interface ILove{
	void lambda();
}

//外部类
class Love implements ILove{
	@Override
	public void lambda() {
      System.out.println("我喜欢学习lambda");		
	}
	
}
