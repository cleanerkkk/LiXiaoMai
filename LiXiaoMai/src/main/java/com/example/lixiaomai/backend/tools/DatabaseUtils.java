package com.example.lixiaomai.backend.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.dbutils.DbUtils;

public class DatabaseUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/takeout";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "LiXiaoMai";

    public static void close(Connection conn) {
        DbUtils.closeQuietly(conn);
    }
    public static void close(Connection conn, Statement st, ResultSet rs) {
        DbUtils.closeQuietly(conn, st, rs);
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}