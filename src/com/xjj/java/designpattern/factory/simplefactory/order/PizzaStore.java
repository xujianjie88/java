package com.xjj.java.designpattern.factory.simplefactory.order;

/**
 * @description: 客户端,发出订购任务
 * @author: xujianjie
 * @create: 2020-07-18 09:34
 **/
public class PizzaStore {

    public static void main(String[] args) {
//        new OrderPizza();
        //方式一：
//        new OrderPizza(new SimpleFactory());
        //方式二：通过静态方法创建
        new OrderPizza2();
    }

}
