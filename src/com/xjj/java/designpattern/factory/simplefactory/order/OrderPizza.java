package com.xjj.java.designpattern.factory.simplefactory.order;

import com.xjj.java.designpattern.factory.simplefactory.pizza.CheesePizza;
import com.xjj.java.designpattern.factory.simplefactory.pizza.GreekPizza;
import com.xjj.java.designpattern.factory.simplefactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-18 09:26
 **/
public class OrderPizza {

//    public OrderPizza(){
//        Pizza pizza = null;
//        //要订购pizza的类型
//        String orderType;
//        do{
//            orderType = getType();
//            if(orderType.equals("greek")){
//                pizza = new GreekPizza();
//                pizza.setName("希腊pizza");
//            }else if(orderType.equals("cheese")){
//                pizza = new CheesePizza();
//                pizza.setName("奶酪pizza");
//            }else {
//                break;
//            }
//            //输出pizza的过程
//            pizza.prepare();
//            pizza.bake();
//            pizza.cut();
//            pizza.box();
//        }while (true);
//    }

    public  OrderPizza(SimpleFactory simpleFactory){
        setSimpleFactory(simpleFactory);
    }

    //定义一个工厂
    private SimpleFactory simpleFactory;
    Pizza pizza = null;

    public void setSimpleFactory(SimpleFactory simpleFactory) {
        String orderType = ""; //用户输入的
        this.simpleFactory = simpleFactory;
        do{
            orderType = getType();
            pizza = simpleFactory.createPizza(orderType);
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
