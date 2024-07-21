package com.example.lixiaomai.backend.tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import com.example.lixiaomai.backend.entity.Order;

public class OrderResultSetHandler implements ResultSetHandler<List<Order>> {

    @Override
    public List<Order> handle(ResultSet rs) throws SQLException {
        List<Order> orderList = new ArrayList<>();
        while (rs.next()) {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setCId(rs.getInt("cId"));
            order.setSId(rs.getInt("sId"));
            order.setDeliverId(rs.getInt("deliverId"));

            // gid
            order.setGId(Tool.StringToList(rs.getString("gId"), Integer.class));

            //goodsNum
            order.setGoodsNum(Tool.StringToList(rs.getString("goodsNum"), Integer.class));

            order.setDiscountNum(Tool.StringToList(rs.getString("discountNum"), Integer.class));
            order.setDiscountId(Tool.StringToList(rs.getString("dId"), Integer.class));



            order.setEndTime(rs.getTimestamp("endTime"));
            order.setStartTime(rs.getTimestamp("startTime"));
            order.setTotal(rs.getDouble("total"));
            order.setStatus(rs.getInt("status"));
            order.setSName(rs.getString("sName"));
            order.setCName(rs.getString("cName"));

            orderList.add(order);
        }
        return orderList;
    }
}
