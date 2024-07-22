package com.example.lixiaomai.backend.tools;

import com.example.lixiaomai.backend.entity.Cart;
import com.example.lixiaomai.backend.entity.Order;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartResultSetHandler implements ResultSetHandler<Cart> {
    public Cart handle(ResultSet rs) throws SQLException {
        Cart cart = new Cart();
        while (rs.next()) {
            cart.setCId(rs.getInt("cId"));
            cart.setGId(Tool.StringToList(rs.getString("gId"), Integer.class));
            cart.setGoodsNum(Tool.StringToList(rs.getString("goodsNum"), Integer.class));
            cart.setTotal(rs.getDouble("total"));


        }
        return cart;
    }

}
