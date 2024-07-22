package com.example.lixiaomai.backend.dao;

import com.example.lixiaomai.backend.entity.Cart;
import com.example.lixiaomai.backend.tools.CartResultSetHandler;
import com.example.lixiaomai.backend.tools.DatabaseUtils;
import com.example.lixiaomai.backend.tools.Tool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class CartDao {
    private final QueryRunner runner = DatabaseUtils.getRunner();
    public Cart getCartByCid(int Cid){
        try {
            String sql = "SELECT * FROM CART WHERE CID = ?";
            Connection conn = DatabaseUtils.getConnection();
            return runner.query(conn, sql, new CartResultSetHandler(), Cid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean updateCart(Cart cart){
        int cid = cart.getCId();
        try{
            String sql = "UPDATE CART SET GID = ?, GOODSNUM = ?, TOTAL = ? WHERE CID = ?";
            Connection conn = DatabaseUtils.getConnection();
            String gid = Tool.ListToString(cart.getGId());
            String goodsNum = Tool.ListToString(cart.getGoodsNum());
            return runner.update(conn, sql,
                    gid, goodsNum, cart.getTotal(), cid) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
