package com.xjj.java.designpattern.adapter.classadapter;

//ÊÊÅäÆ÷Àà
public class VoltageAdapter extends Voltage220V implements Voltage5V {
    @Override
    public int output5V() {
        int srcV = output220V();
        int desV = srcV/44;
        return desV;
    }
}
