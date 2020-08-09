package com.xjj.java.designpattern.adapter.objectadapter;

//适配器类
public class VoltageAdapter  implements Voltage5V {


    private Voltage220V voltage220V;//聚合关系

    //通过构造器传入Voltage220V
    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int dst = 0;
        if(voltage220V!=null){
            int src = voltage220V.output220V();
            dst = src/44;
            System.out.println("适配器完成，输出的电压为="+dst);
        }
        return dst;
    }
}
