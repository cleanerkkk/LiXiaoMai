package com.example.lixiaomai.backend.entity;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;
    private String type;
    private String description;
    private int sId;
    private String pitcutreUrl;
}