package com.xjj.java.designpattern.responsibilitychain;

public abstract class Handler {

    // 下一个处理者
    Handler handler;

    // 名字
    String name;

    public Handler(String name) {
        this.name = name;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    // 处理审批请求的方法,得到一个请求,处理是子类完成,因此该方法作为抽象
    public abstract void processRequest(PurchaseRequest purchaseRequest);
}
