package com.example.lixiaomai.backend.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Data
public class Order {
    private int id;
    private int cId;
    private int sId;
    private int deliverId;
    private List<Integer> gId;
    private List<Integer> goodsNum;
    private Timestamp endTime;

    private Timestamp startTime;
    private double total;
    private int status;
    private String sName;
    private List<Integer> discountNum;
    private List<Integer> discountId;
    private String cName;
}
