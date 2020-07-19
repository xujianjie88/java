package com.xjj.java.designpattern.factory.absfactory.order;

import com.xjj.java.designpattern.factory.absfactory.pizza.BJCheesePizza;
import com.xjj.java.designpattern.factory.absfactory.pizza.BJPepeerPizza;
import com.xjj.java.designpattern.factory.absfactory.pizza.Pizza;
import com.xjj.java.designpattern.factory.simplefactory.pizza.CheesePizza;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-19 11:04
 **/
public class BJFactory implements AbsFactory {

    @Override
    public Pizza CreatePizza(String orderType) {
        System.out.println("使用抽象工厂模式");
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new BJCheesePizza();
        }else if(orderType.equals("pepeer")){
            pizza = new BJPepeerPizza();
        }
        return pizza;
    }
}
