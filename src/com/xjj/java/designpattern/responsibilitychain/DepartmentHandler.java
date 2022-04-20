package com.xjj.java.designpattern.responsibilitychain;

/**
 * ����
 */
public class DepartmentHandler extends Handler {

    public DepartmentHandler(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() <= 5000) {
            System.out.println("������ id = " + purchaseRequest.getId() + "��" + this.name + "����");
        }else {
            handler.processRequest(purchaseRequest);
        }
    }


}
