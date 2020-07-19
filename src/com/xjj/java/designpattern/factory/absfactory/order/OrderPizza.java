package com.xjj.java.designpattern.factory.absfactory.order;

import com.xjj.java.designpattern.factory.absfactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-19 11:07
 **/
public class OrderPizza {

    AbsFactory absFactory;

    public OrderPizza(AbsFactory absFactory){
        setAbsFactory(absFactory);
    }

    private void setAbsFactory(AbsFactory absFactory) {
        Pizza pizza = null;
        String orderType = "";
        this.absFactory = absFactory;
        do {
            orderType = getType();
            pizza = absFactory.CreatePizza(orderType);
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
            System.out.println("请输入要订购的pizza的类型:");
            String str = reader.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
