package com.xjj.java.designpattern.factory.factorymethod.order;

import com.xjj.java.designpattern.factory.factorymethod.pizza.LDCheesePizza;
import com.xjj.java.designpattern.factory.factorymethod.pizza.LDPepeerPizza;
import com.xjj.java.designpattern.factory.factorymethod.pizza.Pizza;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-19 10:48
 **/
public class LDOrderPizza extends OrderPizza {

    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new LDCheesePizza();
        }else if(orderType.equals("pepeer")){
            pizza = new LDPepeerPizza();
        }
        return pizza;
    }
}
