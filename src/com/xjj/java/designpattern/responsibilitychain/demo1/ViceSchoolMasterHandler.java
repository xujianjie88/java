package com.xjj.java.designpattern.responsibilitychain.demo1;

/**
 * 副校长
 */
public class ViceSchoolMasterHandler extends Handler {

    public ViceSchoolMasterHandler(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (10000 <= purchaseRequest.getPrice() && purchaseRequest.getPrice() <= 30000) {
            System.out.println("请求编号 id = " + purchaseRequest.getId() + "被" + this.name + "处理");
        }else {
            handler.processRequest(purchaseRequest);
        }
    }
}
