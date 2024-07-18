package com.example.lixiaomai.backend.dao;

import com.example.lixiaomai.backend.entity.Product;
import com.example.lixiaomai.backend.tools.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDao {
    public boolean addProduct(Product product) {
        String sql = "INSERT INTO PRODUCT (NAME, PRICE, STOCK, TYPE, DESCRIPTION, SID) VALUES (?,?,?,?,?,?)";
        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setString(1, );
            pre.setDouble(2, price);
            pre.setInt(3, stock);
            pre.setString(4, type);
            pre.setString(5, description);
            pre.setInt(6, sid);
            return pre.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delProduct(int id){

    }

    public boolean updateProduct(Product product, int id){

    }


}
