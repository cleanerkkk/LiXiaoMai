package com.example.lixiaomai.backend.dao;
import com.example.lixiaomai.backend.entity.Comment;
import com.example.lixiaomai.backend.entity.Coupon;
import com.example.lixiaomai.backend.entity.Wallet;
import com.example.lixiaomai.backend.tools.DatabaseUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class CouponDAO {
    private final QueryRunner runner = DatabaseUtils.getRunner();

    public Coupon getAllInfoOfCoupon(int id) {
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
            Coupon coupon=getAllInfoOfCoupon(id);
            return runner.update(conn,sql,coupon.getId(),coupon.getLimit(),coupon.getDiscount())>0;
        }
        catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

}
