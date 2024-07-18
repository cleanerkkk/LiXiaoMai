package com.example.lixiaomai.backend.dao;

import com.example.lixiaomai.backend.entity.Customer;
import com.example.lixiaomai.backend.entity.Order;
import com.example.lixiaomai.backend.tools.DatabaseUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerDao {
    private final QueryRunner runner = DatabaseUtils.getRunner();

    public boolean addCustomer(Customer customer){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "INSERT INTO CUSTOMER (NAME, UNAME, PASSWORD, TELEPHONE, GENDER, BIRTHDAY, ADDRESS)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            return runner.update(conn, sql, customer.getName(), customer.getUName(), customer.getPassword(), customer.getTelephone(),
                    customer.getGender(), customer.getBirthday(), customer.getAddress()) > 0;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean delCustomer(int id){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "DELETE FROM CUSTOMER WHERE ID = ?";
            return runner.update(conn, sql, id) > 0;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean updateCustomerInfo(int id, Customer customer){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "UPDATE CUSTOMER SET NAME = ?, UNAME = ?, PASSWORD = ?, TELEPHONE = ?, GENDER = ?, BIRTHDAY = ?, ADDRESS = ? WHERE ID = ?";
            return runner.update(conn, sql, customer.getName(), customer.getUName(), customer.getPassword(),
                    customer.getTelephone(), customer.getGender(), customer.getBirthday(), customer.getAddress(), id) > 0;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Customer findUName(String name, String password){
        try{
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM CUSTOMER WHERE NAME = ? AND PASSWORD = ?";
            Customer customer = runner.query(conn, sql, new BeanHandler<>(Customer.class), name, password);
            return customer;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
