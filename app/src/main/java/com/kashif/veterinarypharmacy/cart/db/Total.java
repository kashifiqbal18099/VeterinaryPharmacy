package com.kashif.veterinarypharmacy.cart.db;

public class Total {
    int totalqty;
    float total;

    public Total(int qty, float total) {
        this.totalqty = qty;
        this.total = total;
    }

    public Total() {
    }

    public int getQty() {
        return totalqty;
    }

    public void setQty(int qty) {
        this.totalqty = qty;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
