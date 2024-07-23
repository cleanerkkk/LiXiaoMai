package com.example.lixiaomai.backend.dao;
import com.example.lixiaomai.backend.entity.Coupon;
import com.example.lixiaomai.backend.entity.Wallet;
import com.example.lixiaomai.backend.tools.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

    public boolean updateWalletById(int id, Wallet wallet) {
        Connection conn = null;
        boolean isUpdated = false;
        try {
            conn = DatabaseUtils.getConnection();
            QueryRunner runner = DatabaseUtils.getRunner();
            String did = Tool.ListToString(wallet.getDId());
            String discountNum = Tool.ListToString(wallet.getDiscountNum());
            String updateQuery = "UPDATE WALLET SET password = ?, balance = ?, did = ?, discountNum = ? WHERE id = ?";
            int rowsAffected = runner.update(conn, updateQuery, wallet.getPassword(), wallet.getBalance(), did, discountNum, id);
            isUpdated = rowsAffected > 0;
            return isUpdated;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addCouponById(int id, Coupon coupon){
        Connection conn = null;
        boolean isUpdated = false;
        try {
            conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM WALLET WHERE id = ?";
            Wallet wallet = runner.query(conn, sql, new WalletResultSetHandler(), id).get(0);
            List<Integer> discountNum = wallet.getDiscountNum();
            List<Integer> did = wallet.getDId();
            int discountId = coupon.getId();
            int ind = -1;
            for (int i = 0; i < did.size(); i++) {
                if (did.get(i) == discountId) {
                    ind = i;
                    break;
                }
            }
            if (ind != -1){
                discountNum.set(ind, discountNum.get(ind) + 1);
                wallet.setDiscountNum(discountNum);
                return updateWalletById(id, wallet);

            } else {
                did.add(discountId);
                discountNum.add(1);
                wallet.setDId(did);
                wallet.setDiscountNum(discountNum);
                return updateWalletById(id, wallet);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delCouponById(int id, int couponId){
        boolean isUpdated = false;
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM WALLET WHERE ID = ?";
            Wallet wallet = runner.query(conn, sql, new WalletResultSetHandler(), id).get(0);
            List<Integer> discountNum = wallet.getDiscountNum();
            List<Integer> discountId = wallet.getDId();
            for (int i = 0; i < discountId.size(); i++){
                if (discountId.get(i) == couponId){
                    discountNum.set(i, discountNum.get(i) - 1);
                    if (discountNum.get(i) == 0){
                        discountNum.remove(i);
                        discountId.remove(i);
                    }
                    wallet.setDiscountNum(discountNum);
                    wallet.setDId(discountId);
                    isUpdated = updateWalletById(id, wallet);
                    break;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isUpdated;
    }
}
