package com.example.lixiaomai.backend.dao;
import com.example.lixiaomai.backend.entity.Wallet;
import com.example.lixiaomai.backend.tools.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class WalletDao {
    private final QueryRunner runner = DatabaseUtils.getRunner();

    public  Wallet getWalletById(int id) {
        try {
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM WALLET WHERE id = ?";
            return runner.query(conn, sql, new WalletResultSetHandler(), id).get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addWallet(Wallet wallet){
        String sql="INSERT INTO WALLET (id, password, balance, did, discountNum) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = DatabaseUtils.getConnection();
            String did = Tool.ListToString(wallet.getDId());
            String discountNum = Tool.ListToString(wallet.getDiscountNum());
            return runner.update(conn,
                    sql,
                    wallet.getId(),wallet.getPassword(),wallet.getBalance(),did,discountNum) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delWalletById(int id){
        try{
            String sql="DELETE FROM WALLET WHERE id = ?";
            Connection conn = DatabaseUtils.getConnection();
            return runner.update(conn,sql,id) > 0;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public boolean updatePasswordById(int id,String newPassword){
        boolean isUpdated = false;
        Connection conn=null;
        try {
            conn = DatabaseUtils.getConnection();
            QueryRunner runner = DatabaseUtils.getRunner();
            String updateQuery = "UPDATE WALLET SET password = ? WHERE id = ?";
            int rowsAffected = runner.update(conn, updateQuery, newPassword, id);
            isUpdated = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtils.close(conn);
        }
        return isUpdated;
    }
    public boolean updateBalanceById(int id, double newBalance) {
        Connection conn = null;
        boolean isUpdated = false;
        try {
            conn = DatabaseUtils.getConnection();
            QueryRunner runner = DatabaseUtils.getRunner();
            String updateQuery = "UPDATE WALLET SET balance = ? WHERE id = ?";
            int rowsAffected = runner.update(conn, updateQuery, newBalance, id);
            isUpdated = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtils.close(conn);
        }
        return isUpdated;
    }
}
