package com.example.lixiaomai.backend.service;

import com.example.lixiaomai.backend.dao.AdminDao;
import com.example.lixiaomai.backend.entity.Admin;

public class AdminService {
    static AdminDao adminDao = new AdminDao();

    public boolean addAdmin(Admin admin){
        return adminDao.addAdmin(admin);
    }

    public boolean delAdmin(int id){
        return adminDao.delAdmin(id);
    }
    123


}
