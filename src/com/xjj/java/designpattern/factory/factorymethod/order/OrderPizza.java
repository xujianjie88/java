package com.xjj.java.designpattern.factory.factorymethod.order;

import com.xjj.java.designpattern.factory.factorymethod.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-19 10:39
 **/
public abstract class OrderPizza {

    //创建一个工厂方法，让各个工厂子类类自己去实现创建pizza
    public abstract Pizza createPizza(String orderType);

    public OrderPizza(){
        Pizza pizza = null;
        //要订购pizza的类型
        String orderType;
        do{
            orderType = getType();
            pizza = createPizza(orderType);
            //输出pizza的过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);
    }

    /**
     * 获取pizza的类型
     */
    public String getType()  {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入要订购的pizza的类型:");
            String str = reader.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
