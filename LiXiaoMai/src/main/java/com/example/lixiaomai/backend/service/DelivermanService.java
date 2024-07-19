package com.example.lixiaomai.backend.service;

import com.example.lixiaomai.backend.dao.DelivermanDao;
import com.example.lixiaomai.backend.entity.Deliverman;

public class DelivermanService {
    static DelivermanDao delivermanDao = new DelivermanDao();

    public boolean addDeliverman(Deliverman deliverman){
        return delivermanDao.addDeliverman(deliverman);
    }

    public boolean delDeliverman(int id){
        return delivermanDao.delDeliverman(id);
    }

    public boolean updateDelivermanInfo(int id, Deliverman deliverman){
        return delivermanDao.updateDelivermanInfo(id, deliverman);
    }

    public Deliverman findUName(String name, String password){
        return delivermanDao.findUName(name, password);
    }
}
