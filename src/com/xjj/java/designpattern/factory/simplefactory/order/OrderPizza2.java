package com.xjj.java.designpattern.factory.simplefactory.order;

import com.xjj.java.designpattern.factory.simplefactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description:通过静态的方法创建简单工厂
 * @author: xujianjie
 * @create: 2020-07-19 10:20
 **/
public class OrderPizza2 {

    //定义一个工厂
    Pizza pizza = null;
    String orderType = ""; //用户输入的
    public OrderPizza2(){
        do{
            orderType = getType();
            pizza = SimpleFactory.createPizza2(orderType);
            if(pizza!=null){
                //输出pizza的过程
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("订购pizza失败");
                break;
            }
        }while (true);
    }

    /**
     * 获取pizza的类型
     */
    public String getType()  {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入要订购的pizza的类型");
            String str = reader.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
