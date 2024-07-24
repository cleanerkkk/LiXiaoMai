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

    public boolean login(String username, String password){
        Admin admin = adminDao.getAdminByUserName(username);
        return admin != null && admin.getPassword().equals(password);
    }

    public Admin getAdminByUserName(String uname){
        return adminDao.getAdminByUserName(uname);
    }

    public Admin getAllInfoOfAdmin(int id){
        return adminDao.getAllInfoOfAdmin(id);
    }




}
