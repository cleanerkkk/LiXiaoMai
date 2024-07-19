package com.example.lixiaomai.backend.service;

import com.example.lixiaomai.backend.dao.BusinessDao;
import com.example.lixiaomai.backend.entity.Business;

public class BusinessService {
    static BusinessDao businessDao = new BusinessDao();

    public boolean login(String username, String password) {
        Business business = businessDao.getBusinessByUsername(username);
        return business != null && business.getPassword().equals(password);
    }

    public Business getAllInfoOfBusiness(int id){
        return businessDao.getAllInfoOfBusiness(id);
    }

    public boolean addBusiness(Business business){
        return businessDao.addBusiness(business);
    }

    public boolean delBusiness(int id){
        return businessDao.delBusiness(id);
    }

    public boolean updateBusiness(Business business){
        return businessDao.updateBusiness(business);
    }

    public boolean updatePasswordById(int id, String newPassword){
        return businessDao.updatePasswordById(id, newPassword);
    }

    public boolean updateShopNameById(int id, String newshopName){
        return businessDao.updateShopNameById(id, newshopName);
    }

    public boolean updateIdCardById(int id,String newIdCard){
        return businessDao.updateIdCardById(id, newIdCard);
    }

    public boolean updateTelephoneById(int id,String Telephone){
        return businessDao.updateTelephoneById(id, Telephone);
    }

    public boolean updateAddressById(int id,String newAddress){
        return businessDao.updateAddressById(id, newAddress);
    }

    public boolean updateUnameById(int id,String newUName){
        return businessDao.updateUnameById(id, newUName);
    }

    public boolean updateNameById(int id,String newName){
        return businessDao.updateNameById(id, newName);
    }
}
