package com.example.lixiaomai.backend.dao;

import com.example.lixiaomai.backend.entity.Business;
import com.example.lixiaomai.backend.tools.DatabaseUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class BusinessDAO {
    private final QueryRunner runner = DatabaseUtils.getRunner();

    public Business getAllInfoOfBusiness(int id) {
        try {
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM Business WHERE id = ?";
            return runner.query(conn, sql, new BeanHandler<>(Business.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addBusiness(Business business) {
        String sql = "INSERT INTO Business (id, password, shopName, uName, name, address, telephone, idCard) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = DatabaseUtils.getConnection();
            return runner.update(conn, sql, business.getId(), business.getPassword(), business.getShopName(), business.getUName(), business.getName(), business.getAddress(), business.getTelephone(), business.getIdCard()) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delBusiness(int id) {
        String sql = "DELETE FROM Business WHERE id = ?";
        try {
            Connection conn = DatabaseUtils.getConnection();
            return runner.update(conn, sql, id) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateBusiness(Business business) {
        String sql = "UPDATE Business SET password = ?, shopName = ?, uName = ?, name = ?, address = ?, telephone = ?, idCard = ? WHERE id = ?";
        try {
            Connection conn = DatabaseUtils.getConnection();
            return runner.update(conn, sql, business.getPassword(), business.getShopName(), business.getUName(), business.getName(), business.getAddress(), business.getTelephone(), business.getIdCard(), business.getId()) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
