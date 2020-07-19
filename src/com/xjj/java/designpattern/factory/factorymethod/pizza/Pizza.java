package com.xjj.java.designpattern.factory.factorymethod.pizza;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-18 09:19
 **/
public abstract class Pizza {

    /**
     * 披萨的名称
     */
    private String name;

    /**
     * 准备原材料
     */
    public abstract void prepare();

    public void bake(){
        System.out.println(name+":bake");
    }

    public void cut(){
        System.out.println(name+":cut");
    }


    public void box(){
        System.out.println(name+":box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
