package com.xjj.java.designpattern.responsibilitychain.demo1;

/**
 * 主任
 */
public class DepartmentHandler extends Handler {

    public DepartmentHandler(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() <= 5000) {
            System.out.println("请求编号 id = " + purchaseRequest.getId() + "被" + this.name + "处理");
        }else {
            handler.processRequest(purchaseRequest);
        }
    }


}
