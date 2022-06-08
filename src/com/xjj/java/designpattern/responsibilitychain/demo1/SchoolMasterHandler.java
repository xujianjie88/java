package com.xjj.java.designpattern.responsibilitychain.demo1;

/**
 * 校长
 */
public class SchoolMasterHandler extends Handler {

    public SchoolMasterHandler(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice()>30000) {
            System.out.println("请求编号 id = " + purchaseRequest.getId() + "被" + this.name + "处理");
        }else {
            handler.processRequest(purchaseRequest);
        }

    }
}
