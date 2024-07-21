package com.example.lixiaomai.backend.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class sqlRelated {

    // 数据库连接参数

    public static void main(String[] args) {
        String folderPath = "LiXiaoMai/数据库/数据";
        executeSQLFile(new File("LiXiaoMai/数据库/create.sql"), DatabaseUtils.getConnection());
        executeAllSQLInFolder(folderPath);
    }

    public static void executeAllSQLInFolder(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".sql"));

        if (files == null) {
            System.out.println("Folder is empty or does not exist.");
            return;
        }

        try (Connection connection = DatabaseUtils.getConnection()) {
            for (File file : files) {
                executeSQLFile(file, connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeSQLFile(File file, Connection connection) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder sql = new StringBuilder();
            while ((line = reader.readLine())!= null) {
                // 去除注释和空行
                if (!line.startsWith("--") &&!line.trim().isEmpty()) {
                    sql.append(line).append(" ");
                }

                // 如果遇到分号，认为是一条完整的 SQL 语句
                if (line.endsWith(";")) {
                    try (PreparedStatement statement = connection.prepareStatement(sql.toString())) {
                        statement.execute();
                    } catch (SQLException e) {
                        System.out.println("Error executing SQL in file: " + file.getName());
                        e.printStackTrace();
                    }
                    sql.setLength(0);  // 清空 StringBuilder 以准备下一条语句
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}