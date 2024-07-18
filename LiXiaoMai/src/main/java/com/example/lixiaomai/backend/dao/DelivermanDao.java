package com.example.lixiaomai.backend.dao;

import com.example.lixiaomai.backend.entity.Customer;
import com.example.lixiaomai.backend.entity.Deliverman;
import com.example.lixiaomai.backend.tools.DatabaseUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;

public class DelivermanDao {
    private final QueryRunner runner = DatabaseUtils.getRunner();

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
                    deliverman.getGender(), deliverman.getVType(), deliverman.getVId(), deliverman.getVBrand()) > 0;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public String findUName(String name, String password){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM DELIVERMAN WHERE NAME = ? AND PASSWORD = ?";
            Deliverman deliverman = runner.query(conn, sql, new BeanHandler<>(Deliverman.class), name, password);
            if(deliverman.equals(null)){
                return "输入信息错误，请重试。";
            }else{
                return runner.query(conn, sql, new BeanHandler<>(Customer.class), name, password).getUName();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
