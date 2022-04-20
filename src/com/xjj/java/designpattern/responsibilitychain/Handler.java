package com.xjj.java.designpattern.responsibilitychain;

public abstract class Handler {

    // ��һ��������
    Handler handler;

    // ����
    String name;

    public Handler(String name) {
        this.name = name;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    // ������������ķ���,�õ�һ������,�������������,��˸÷�����Ϊ����
    public abstract void processRequest(PurchaseRequest purchaseRequest);
}
