package com.example.lixiaomai.backend.dao;
import com.example.lixiaomai.backend.entity.Coupon;
import com.example.lixiaomai.backend.tools.DatabaseUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class CouponDao {
    private final QueryRunner runner = DatabaseUtils.getRunner();

    public Coupon getCouponById(int id) {
        try {
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM COUPON WHERE id = ?";
            return runner.query(conn, sql, new BeanListHandler<>(Coupon.class), id).get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean addCoupon(Coupon coupon){
        String sql="INSERT INTO COUPON (`id`, `limit`, `discount`) VALUES (?, ?, ?)";
        try {
            Connection conn = DatabaseUtils.getConnection();
            return runner.update(conn,
                    sql,
                    coupon.getId(),coupon.getLimit(),coupon.getDiscount()) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delCoupon(int id){
        String sql="DELETE FROM COUPON where id=?";
        try{
            Connection conn=DatabaseUtils.getConnection();
            Coupon coupon= getCouponById(id);
            return runner.update(conn,sql,coupon.getId(),coupon.getLimit(),coupon.getDiscount())>0;
        }
        catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }
    public boolean updateLimitById(int id, int newLimit) {
        Connection conn = null;
        boolean isUpdated = false;
        try {
            conn = DatabaseUtils.getConnection();
            QueryRunner runner = DatabaseUtils.getRunner();
            String updateQuery = "UPDATE Coupon SET limit = ? WHERE id = ?";
            int rowsAffected = runner.update(conn, updateQuery, newLimit, id);
            isUpdated = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtils.close(conn);
        }
        return isUpdated;
    }
    public boolean updateDiscountById(int id,double newDiscount) {
        Connection conn = null;
        boolean isUpdated = false;
        try {
            conn = DatabaseUtils.getConnection();
            QueryRunner runner = DatabaseUtils.getRunner();
            String updateQuery = "UPDATE Coupon SET  discount = ? WHERE id = ?";
            int rowsAffected = runner.update(conn, updateQuery, newDiscount, id);
            isUpdated = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtils.close(conn);
        }
        return isUpdated;
    }


}
