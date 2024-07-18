package main.java.com.example.lixiaomai.backend.entity;


import lombok.Data;

import java.util.List;

@Data
public class Cart {
    private int  cId;
    private List<Integer> gId;
    private List<Integer> goodsNum;
    private double total;

}
