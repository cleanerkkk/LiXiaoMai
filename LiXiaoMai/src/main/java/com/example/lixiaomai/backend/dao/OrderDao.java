package com.example.lixiaomai.backend.dao;

import com.example.lixiaomai.backend.entity.Order;
import com.example.lixiaomai.backend.tools.DatabaseUtils;
import com.example.lixiaomai.backend.tools.OrderResultSetHandler;
import com.example.lixiaomai.backend.tools.Tool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDao {
    private final QueryRunner runner = DatabaseUtils.getRunner();


    public List<Order> getAllOrdersWithNoDeliver(){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM `ORDER` WHERE deliverId = ?";
            return runner.query(conn, sql, new OrderResultSetHandler(), 0);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Order> getAllOrderByCid(int cId){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM `ORDER` WHERE cid = ?";
            return runner.query(conn, sql, new OrderResultSetHandler(), cId);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public List<Order> getAllOrderByDeliverId(int did){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM `ORDER` WHERE deliverID = ?";
            return runner.query(conn, sql, new OrderResultSetHandler(), did);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public List<Order> getAllOrderBySid(int sId){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM `ORDER` WHERE sid = ?";
            return runner.query(conn, sql, new OrderResultSetHandler(), sId);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean addOrder(Order order){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "INSERT INTO `ORDER` (CID, SID, GID, deliverID, GOODSNUM, ENDTIME, STARTTIME, TOTAL, STATUS, SNAME, DISCOUNTNUM, DID, CNAME) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            String gId = Tool.ListToString(order.getGId());
            String goodsNum = Tool.ListToString(order.getGoodsNum());
            String discountId = Tool.ListToString(order.getDiscountId());
            String discountNum = Tool.ListToString(order.getDiscountNum());
            return runner.update(conn, sql,
                    order.getCId(), order.getSId(), gId,order.getDeliverId() , goodsNum, order.getEndTime(), order.getStartTime(), order.getTotal(), order.getStatus(), order.getSName(), discountNum, discountId, order.getCName()) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateOrder(Order order){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "UPDATE `ORDER` SET CID = ?, SID = ?, GID = ?, GOODSNUM = ?, ENDTIME = ?, STARTTIME = ?, TOTAL = ?, STATUS = ?, SNAME = ?, DISCOUNTNUM = ?, DID = ?, CNAME = ? WHERE ID = ?";
            String gId = Tool.ListToString(order.getGId());
            String goodsNum = Tool.ListToString(order.getGoodsNum());
            String discountId = Tool.ListToString(order.getDiscountId());
            String discountNum = Tool.ListToString(order.getDiscountNum());
            return runner.update(conn, sql,
                    order.getCId(), order.getSId(), gId, goodsNum, order.getEndTime(), order.getStartTime(), order.getTotal(), order.getStatus(), order.getSName(), discountNum, discountId, order.getCName(), order.getId()) > 0;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean delOrderById(int id){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "DELETE FROM `ORDER` WHERE ID = ?";
            return runner.update(conn, sql, id) > 0;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Order getOrderById(int id){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM `ORDER` WHERE ID = ?";
            return runner.query(conn, sql, new OrderResultSetHandler(), id).get(0);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
