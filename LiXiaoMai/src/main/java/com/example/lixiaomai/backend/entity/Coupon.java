package com.example.lixiaomai.backend.entity;

public class Coupon {
    private int id;
    private int limit;
    private double discount;
    public Coupon(int id,int limit,double discount){
        this.id=id;
        this.limit=limit;
        this.discount=discount;
    }

    public double getDiscount() {
        return discount;
    }

    public int getId() {
        return id;
    }

    public int getLimit() {
        return limit;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
