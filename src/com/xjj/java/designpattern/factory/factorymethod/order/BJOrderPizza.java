package com.xjj.java.designpattern.factory.factorymethod.order;


import com.xjj.java.designpattern.factory.factorymethod.pizza.BJCheesePizza;
import com.xjj.java.designpattern.factory.factorymethod.pizza.BJPepeerPizza;
import com.xjj.java.designpattern.factory.factorymethod.pizza.Pizza;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-19 10:45
 **/
public class BJOrderPizza extends OrderPizza {

    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new BJCheesePizza();
        }else if(orderType.equals("pepeer")){
            pizza = new BJPepeerPizza();
        }
        return pizza;
    }
}
