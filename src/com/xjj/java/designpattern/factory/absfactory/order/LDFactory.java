package com.xjj.java.designpattern.factory.absfactory.order;

import com.xjj.java.designpattern.factory.absfactory.pizza.*;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-19 11:06
 **/
public class LDFactory implements AbsFactory {

    @Override
    public Pizza CreatePizza(String orderType) {
        System.out.println("使用抽象工厂模式");
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new LDCheesePizza();
        }else if(orderType.equals("pepeer")){
            pizza = new LDPepeerPizza();
        }
        return pizza;
    }
}
