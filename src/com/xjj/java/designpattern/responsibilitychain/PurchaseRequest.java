package com.xjj.java.designpattern.responsibilitychain;

/**
 * π∫¬Ú«Î«Û
 */
public class PurchaseRequest {

    private int type = 0;
    private float price = 0.0f;
    private int id;

    public PurchaseRequest(int type,float price, int id) {
        this.type = type;
        this.price = price;
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
