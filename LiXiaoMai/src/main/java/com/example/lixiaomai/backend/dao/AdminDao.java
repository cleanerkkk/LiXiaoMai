package com.example.lixiaomai.backend.dao;

import com.example.lixiaomai.backend.entity.Admin;
import com.example.lixiaomai.backend.tools.DatabaseUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class AdminDao {
    private final QueryRunner runner = DatabaseUtils.getRunner();
    public Admin getAllInfoOfAdmin(int id){
        try{
            Connection conn=DatabaseUtils.getConnection();
            String sql="SELECT * FROM ADMIN WHERE id=?";
            return runner.query(conn, sql, new BeanHandler<>(Admin.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Admin getAdminByUserName(String uname){
        try{
            Connection conn=DatabaseUtils.getConnection();
            String sql="SELECT * FROM ADMIN WHERE uname=?";
            return runner.query(conn, sql, new BeanHandler<>(Admin.class), uname);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean addAdmin(Admin admin){
        try{
            Connection conn=DatabaseUtils.getConnection();
            String sql="INSERT INTO ADMIN (id, password, uname) VALUES (?, ?, ?)";
            return runner.update(conn,sql,admin.getId(),admin.getPassword(),admin.getUName())>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean delAdmin(int id){
        Admin admin=getAllInfoOfAdmin(id);
        try{
            Connection conn=DatabaseUtils.getConnection();
            String sql="DELETE FROM ADMIN WHERE id=?";
            return runner.update(conn,sql,admin.getId())>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
