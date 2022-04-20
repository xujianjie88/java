package com.xjj.java.designpattern.responsibilitychain;

/**
 *院长
 */
public class CollegeHandler extends Handler {

    public CollegeHandler(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (5000 <= purchaseRequest.getPrice() && purchaseRequest.getPrice() <= 10000) {
            System.out.println("请求编号 id = " + purchaseRequest.getId() + "被" + this.name + "处理");
        }else {
            handler.processRequest(purchaseRequest);
        }
    }
}
