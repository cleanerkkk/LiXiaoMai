package main.java.com.example.lixiaomai.backend.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Order {
    int id;
    int cId;
    int sId;
    List<Integer> gId;
    List<Integer> goodsNum;
    Timestamp endTime;

    Timestamp startTime;
    double total;
    int state;
    String sName;
    List<Integer> discountNum;
    List<Integer> discountId;
    String cName;
}
