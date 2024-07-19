package com.example.lixiaomai.backend.service;

import com.example.lixiaomai.backend.dao.BusinessDao;
import com.example.lixiaomai.backend.entity.Business;

public class BusinessService {
    static BusinessDao businessDao = new BusinessDao();

    public boolean login(String username, String password) {
        Business business = businessDao.getUserByUsername(username);
        return business != null && business.getPassword().equals(password);
    }
}
