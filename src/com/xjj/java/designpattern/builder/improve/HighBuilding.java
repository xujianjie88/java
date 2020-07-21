package com.xjj.java.designpattern.builder.improve;

public class HighBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("建高楼地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("建高楼砌砖");
    }

    @Override
    public void roofed() {
        System.out.println("建高楼封顶");
    }
}
