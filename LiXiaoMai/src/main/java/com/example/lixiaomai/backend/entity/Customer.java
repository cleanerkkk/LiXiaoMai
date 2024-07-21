package com.example.lixiaomai.backend.entity;

import lombok.Data;

import java.sql.Date;
@Data
public class Customer {
    private int id;
    private String name;
    private String uName;
    private String password;
    private String telephone;
    private String gender;
    private Date birthday;
    private String address;
}