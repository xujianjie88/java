package com.xjj.java.designpattern.builder.improve;

public class Client {

    public static void main(String[] args) {
        //盖普通的房子
        CommonHouse commonHouse = new CommonHouse();
        //z准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        //完成盖房子，返回房子
        House house = houseDirector.constructHouse();

        System.out.println("================");
        //盖高楼
        HighBuilding highBuilding = new HighBuilding();
        //重置建造者
        houseDirector.setHouseBuilder(highBuilding);
        //完成盖房子，返回产品高楼
         house = houseDirector.constructHouse();

    }
}
