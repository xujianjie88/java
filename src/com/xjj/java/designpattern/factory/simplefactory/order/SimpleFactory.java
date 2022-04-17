package com.xjj.java.designpattern.factory.simplefactory.order;

import com.xjj.java.designpattern.factory.simplefactory.pizza.CheesePizza;
import com.xjj.java.designpattern.factory.simplefactory.pizza.GreekPizza;
import com.xjj.java.designpattern.factory.simplefactory.pizza.Pizza;

/**
 * @description:�򵥹�����
 * @author: xujianjie
 * @create: 2020-07-19 10:00
 **/
public class SimpleFactory {
    //����orderType���ؾ����pizza

    public Pizza createPizza(String orderType){
        Pizza pizza = null;
        if(orderType.equals("greek")){
            pizza = new GreekPizza();
            pizza.setName("ϣ��pizza");
        }else if(orderType.equals("cheese")){
            pizza = new CheesePizza();
            pizza.setName("����pizza");
        }
        return pizza;
    }

    // �򵥹���ģʽҲ�о�̬����ģʽ
    public static Pizza createPizza2(String orderType){
        Pizza pizza = null;
        if(orderType.equals("greek")){
            pizza = new GreekPizza();
            pizza.setName("ϣ��pizza");
        }else if(orderType.equals("cheese")){
            pizza = new CheesePizza();
            pizza.setName("����pizza");
        }
        return pizza;
    }

}
