package com.example.lixiaomai.backend.entity;

import lombok.Data;

@Data
public class Coupon {
    private int id;
    private int limit;
    private double discount;

    public Coupon(int id, int limit, double discount) {
        this.id = id;
        this.limit = limit;
        this.discount = discount;
    }
}
