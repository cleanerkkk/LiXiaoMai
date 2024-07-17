package com.example.lixiaomai.backend.entity;

import java.sql.Timestamp;

public class Comment {
    private int id;
    private int startId;
    private int endId;
    private String content;
    private  Timestamp time;

    private String startName;
    private  String endName;
    private int likes;
    private int dislikes;
    private int coId;
    private int status;
}
