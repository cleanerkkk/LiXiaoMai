package main.java.com.example.lixiaomai.backend.entity;

import java.sql.Timestamp;

public class Comment {
    int id;
    int startId;
    int endId;
    String content;
    Timestamp time;

    String startName;
    String endName;
    int likes;
    int dislikes;
    int coId;
    int status;
}
