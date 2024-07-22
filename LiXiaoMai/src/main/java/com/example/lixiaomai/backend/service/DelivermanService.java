package com.example.lixiaomai.backend.service;

import com.example.lixiaomai.backend.dao.DelivermanDao;
import com.example.lixiaomai.backend.entity.Deliverman;

public class DelivermanService {
    static DelivermanDao delivermanDao = new DelivermanDao();

    public boolean addDeliverman(Deliverman deliverman){
        return delivermanDao.addDeliverman(deliverman);
    }

    public  Deliverman getDelivermanById(int id){
        return delivermanDao.getDelivermanById(id);
    }
    public boolean delDeliverman(int id){
        return delivermanDao.delDeliverman(id);
    }

    public boolean updateDelivermanInfo(int id, Deliverman deliverman){
        return delivermanDao.updateDelivermanInfo(id, deliverman);
    }

    public Deliverman getDelivermanByUsername(String username){
        return delivermanDao.findUserByUsername(username);
    }

    public boolean existDeliverman(String username){
        return delivermanDao.findUserByUsername(username) != null;
    }

    public boolean login(String username, String password) {
        Deliverman deliverman = delivermanDao.findUserByUsername(username);
        return deliverman != null && deliverman.getPassword().equals(password);
    }
    public Deliverman findUName(String name, String password){
        return delivermanDao.findUName(name, password);
    }
}
