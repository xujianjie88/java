package com.xjj.java.designpattern.factory.simplefactory.order;

import com.xjj.java.designpattern.factory.simplefactory.pizza.CheesePizza;
import com.xjj.java.designpattern.factory.simplefactory.pizza.GreekPizza;
import com.xjj.java.designpattern.factory.simplefactory.pizza.Pizza;

/**
 * @description:简单工厂类
 * @author: xujianjie
 * @create: 2020-07-19 10:00
 **/
public class SimpleFactory {
    //根据orderType返回具体的pizza

    public Pizza createPizza(String orderType){
        Pizza pizza = null;
        if(orderType.equals("greek")){
            pizza = new GreekPizza();
            pizza.setName("希腊pizza");
        }else if(orderType.equals("cheese")){
            pizza = new CheesePizza();
            pizza.setName("奶酪pizza");
        }
        return pizza;
    }

    // 简单工厂模式也叫静态工厂模式
    public static Pizza createPizza2(String orderType){
        Pizza pizza = null;
        if(orderType.equals("greek")){
            pizza = new GreekPizza();
            pizza.setName("希腊pizza");
        }else if(orderType.equals("cheese")){
            pizza = new CheesePizza();
            pizza.setName("奶酪pizza");
        }
        return pizza;
    }

}
