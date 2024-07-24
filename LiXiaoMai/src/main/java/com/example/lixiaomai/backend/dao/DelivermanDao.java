package com.example.lixiaomai.backend.dao;

import com.example.lixiaomai.backend.entity.Customer;
import com.example.lixiaomai.backend.entity.Deliverman;
import com.example.lixiaomai.backend.tools.DatabaseUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;

public class DelivermanDao {
    private final QueryRunner runner = DatabaseUtils.getRunner();

    public List<Deliverman> getDelivermanByStatus(int status){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM DELIVERMAN WHERE STATUS = ?";
            return runner.query(conn, sql, new BeanListHandler<>(Deliverman.class), status);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean addDeliverman(Deliverman deliverman){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "INSERT INTO DELIVERMAN (NAME, UNAME, PASSWORD, TELEPHONE, GENDER, VTYPE, VID, VBRAND, STATUS)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            return runner.update(conn, sql, deliverman.getName(), deliverman.getUName(), deliverman.getPassword(),
                    deliverman.getTelephone(), deliverman.getGender(), deliverman.getVType(), deliverman.getVId(),
                    deliverman.getVBrand(), deliverman.getStatus()) > 0;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Deliverman getDelivermanById(int id){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM DELIVERMAN WHERE ID = ?";
            Deliverman deliverman = runner.query(conn, sql, new BeanHandler<>(Deliverman.class), id);
            return deliverman;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean delDeliverman(int id){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "DELETE FROM CUSTOMER WHERE ID = ?";
            return runner.update(conn, sql, id) > 0;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean updateDelivermanInfo(int id, Deliverman deliverman){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "UPDATE DELIVERMAN SET NAME = ?, UNAME = ?, PASSWORD = ?, TELEPHONE = ?, GENDER = ?, VTYPE = ?, VID = ?, VBRAND = ?, STATUS = ? WHERE ID = ?";
            return runner.update(conn, sql, deliverman.getName(), deliverman.getUName(), deliverman.getPassword(), deliverman.getTelephone(),
                    deliverman.getGender(), deliverman.getVType(), deliverman.getVId(), deliverman.getVBrand(),deliverman.getStatus(),id) > 0;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Deliverman findUserByUsername(String username){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM DELIVERMAN WHERE UNAME = ?";
            Deliverman deliverman = runner.query(conn, sql, new BeanHandler<>(Deliverman.class), username);
            return deliverman;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Deliverman findUName(String name, String password){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM DELIVERMAN WHERE NAME = ? AND PASSWORD = ?";
            Deliverman deliverman = runner.query(conn, sql, new BeanHandler<>(Deliverman.class), name, password);
            return deliverman;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
