package com.example.lixiaomai.backend.dao;

import com.example.lixiaomai.backend.entity.Order;
import com.example.lixiaomai.backend.tools.DatabaseUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDao {
    private final QueryRunner runner = DatabaseUtils.getRunner();

    public List<Order> getAllOrderByCid(int cId){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM ORDER WHERE cid = ?";
            return runner.query(conn, sql, new BeanListHandler<>(Order.class), cId);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean addOrder(Order order){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "INSERT INTO ORDER (ID, CID, SID, GID, GOODSNUM, ENDTIME, STARTTIME, TOTAL, STATUS, SNAME, DISCOUNTNUM, DID, CNAME)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            return runner.update(conn, sql, order.getId(), order.getCId(), order.getSId(), order.getGId(), order.getGoodsNum(), order.getEndTime(),
                    order.getStartTime(), order.getTotal(), order.getStatus(), order.getSName(), order.getDiscountNum(), order.getDiscountId(), order.getCName()) > 0;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
