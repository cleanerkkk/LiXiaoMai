package com.example.lixiaomai.backend.dao;

import com.example.lixiaomai.backend.entity.Business;
import com.example.lixiaomai.backend.tools.DatabaseUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BusinessDao {
    private final QueryRunner runner = DatabaseUtils.getRunner();

    public List<Business> getBusinessByStatus(int status){
        try {
            String sql = "SELECT * FROM Business WHERE status = ?";
            Connection conn = DatabaseUtils.getConnection();
            return runner.query(conn, sql, new BeanListHandler<>(Business.class), status);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Business getBusinessById(int id){
        try {
            String sql = "SELECT * FROM Business WHERE id = ?";
            Connection conn = DatabaseUtils.getConnection();
            return runner.query(conn, sql, new BeanHandler<>(Business.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Business getAllInfoOfBusiness(int id) {
        try {
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM Business WHERE id = ?";
            return runner.query(conn, sql, new BeanHandler<>(Business.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addBusiness(Business business) {
        String sql = "INSERT INTO Business (password, shopName, uName, name, address, telephone, idCard) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = DatabaseUtils.getConnection();
            return runner.update(conn, sql,business.getPassword(), business.getShopName(), business.getUName(), business.getName(), business.getAddress(), business.getTelephone(), business.getIdCard()) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delBusiness(int id) {
        String sql = "DELETE FROM Business WHERE id = ?";
        try {
            Connection conn = DatabaseUtils.getConnection();
            return runner.update(conn, sql, id) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateBusiness(Business business) {
        String sql = "UPDATE Business SET password = ?, shopName = ?, uName = ?, name = ?, address = ?, telephone = ?, idCard = ? WHERE id = ?";
        try {
            Connection conn = DatabaseUtils.getConnection();
            return runner.update(conn, sql, business.getPassword(), business.getShopName(), business.getUName(), business.getName(), business.getAddress(), business.getTelephone(), business.getIdCard(), business.getId()) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean updatePasswordById(int id, String newPassword) {
        Connection conn = null;
        boolean isUpdated = false;
        try {
            conn = DatabaseUtils.getConnection();
            String updateQuery = "UPDATE Business SET password = ? WHERE id = ?";
            int rowsAffected = runner.update(conn, updateQuery, newPassword, id);
            isUpdated = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtils.close(conn);
        }
        return isUpdated;
    }
    public boolean updateShopNameById(int id, String newshopName) {
        Connection conn = null;
        boolean isUpdated = false;
        try {
            conn = DatabaseUtils.getConnection();
            String updateQuery = "UPDATE Business SET shopName = ? WHERE id = ?";
            int rowsAffected = runner.update(conn, updateQuery, newshopName, id);
            isUpdated = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtils.close(conn);
        }
        return isUpdated;
    }
    public boolean updateIdCardById(int id,String newIdCard){
        Connection conn = null;
        boolean isUpdated = false;
        try {
            conn = DatabaseUtils.getConnection();
            String updateQuery = "UPDATE Business SET idCard = ? WHERE id = ?";
            int rowsAffected = runner.update(conn, updateQuery,newIdCard, id);
            isUpdated = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtils.close(conn);
        }
        return isUpdated;
    }
    public boolean updateTelephoneById(int id,String Telephone){
        Connection conn = null;
        boolean isUpdated = false;
        try {
            conn = DatabaseUtils.getConnection();
            String updateQuery = "UPDATE Business SET telephone = ? WHERE id = ?";
            int rowsAffected = runner.update(conn, updateQuery,Telephone, id);
            isUpdated = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtils.close(conn);
        }
        return isUpdated;
    }
    public boolean updateAddressById(int id,String newAddress){
        Connection conn = null;
        boolean isUpdated = false;
        try {
            conn = DatabaseUtils.getConnection();
            String updateQuery = "UPDATE Business SET address = ? WHERE id = ?";
            int rowsAffected = runner.update(conn, updateQuery,newAddress, id);
            isUpdated = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtils.close(conn);
        }
        return isUpdated;
    }
    public boolean updateUnameById(int id,String newUName){
        Connection conn = null;
        boolean isUpdated = false;
        try {
            conn = DatabaseUtils.getConnection();
            String updateQuery = "UPDATE Business SET uname = ? WHERE id = ?";
            int rowsAffected = runner.update(conn, updateQuery,newUName, id);
            isUpdated = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtils.close(conn);
        }
        return isUpdated;
    }
    public boolean updateNameById(int id,String newName){
        Connection conn = null;
        boolean isUpdated = false;
        try {
            conn = DatabaseUtils.getConnection();
            String updateQuery = "UPDATE Business SET name = ? WHERE id = ?";
            int rowsAffected = runner.update(conn, updateQuery,newName, id);
            isUpdated = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtils.close(conn);
        }
        return isUpdated;
    }

    public Business getBusinessByUsername(String uname) {
        try {
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM Business WHERE uname = ?";
            return runner.query(conn, sql, new BeanHandler<>(Business.class), uname);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Business> getAllBusiness(){
        try {
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM Business";
            return runner.query(conn, sql, new BeanListHandler<>(Business.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
