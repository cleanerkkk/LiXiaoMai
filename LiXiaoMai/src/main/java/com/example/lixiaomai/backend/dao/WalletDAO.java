package com.example.lixiaomai.backend.dao;
import com.example.lixiaomai.backend.entity.Coupon;
import com.example.lixiaomai.backend.entity.Wallet;
import com.example.lixiaomai.backend.tools.*;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class WalletDAO {
    private final QueryRunner runner = DatabaseUtils.getRunner();

    public  Wallet getAllInfoOfWallet(int id) {
        try {
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM Wallet WHERE id = ?";
            return runner.query(conn, sql, new BeanListHandler<>(Wallet.class), id).get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public double getBalanceWithId(int id){
        Wallet wallet = getAllInfoOfWallet(id);
        return wallet != null ? wallet.getBalance() : 0;
    }
    public boolean addWallet(Wallet wallet){
        String sql="INSERT INTO WALLET (id, password, balance, did, discountNum) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = DatabaseUtils.getConnection();
            return runner.update(conn,
                    sql,
                    wallet.getId(),wallet.getPassword(),wallet.getBalance(),wallet.getDId(),wallet.getDiscountNum()) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
