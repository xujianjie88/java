package com.xjj.java.designpattern.principle.Liskov.improve;

public class LiskovImprove {

    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3="+a.function1(11,3));
        System.out.println("1-8="+a.function1(1,8));

        System.out.println("=======");
        B b = new B();
        System.out.println("11+3="+b.function1(11,3));
        System.out.println("1+8="+b.function1(1,8));
        System.out.println("11+3+9="+b.function2(11,3));

        //使用组合调用A类相关的方法
        System.out.println("11-3="+b.function3(11,3));
    }


}

class Base{
    //把更基础的东西写在这里

}

class A extends Base{
    //返回两个数的差
    public int function1(int num1,int num2){
        return num1-num2;
    }
}

class B extends Base{
    //如果B类要用A类的方法的话，使用组合关系
   private A a = new A();
    //这里重写了A的方法
    public int function1(int a,int b){
        return a+b;
    }

    public int function2(int a,int b){
        return function1(a,b)+9;
    }

    //返回两个数的差
    public int function3(int num1,int num2){
        return num1-num2;
    }
}

