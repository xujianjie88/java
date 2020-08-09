package com.xjj.java.designpattern.adapter.objectadapter;

public class Phone {

    //充电
    public void charging(Voltage5V voltage5V){
        if(voltage5V.output5V()==5){
            System.out.println("电压5伏，可以充电了");
        }else if(voltage5V.output5V()>5){
            System.out.println("电压大于5伏，不可以充电了");
        }
    }
}
