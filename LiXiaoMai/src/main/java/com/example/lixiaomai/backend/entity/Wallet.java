package com.example.lixiaomai.backend.entity;

import lombok.Data;

import java.util.List;
@Data
public class Wallet {
    private int id;
    private String password;
    private double balance;
    private List<Integer> dId;
    private List<Double> discountNum;

}
