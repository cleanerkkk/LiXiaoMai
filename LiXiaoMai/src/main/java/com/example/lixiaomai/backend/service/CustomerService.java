package com.example.lixiaomai.backend.service;

import com.example.lixiaomai.backend.dao.CustomerDao;
import com.example.lixiaomai.backend.entity.Customer;
import sun.security.krb5.internal.ccache.CCacheInputStream;

public class CustomerService {
    static CustomerDao customerDao = new CustomerDao();

    public boolean addCustomer(Customer customer){
        return customerDao.addCustomer(customer);
    }

    public boolean delCustomer(int id){
        return customerDao.delCustomer(id);
    }

    public boolean updateCustomerInfo(int id, Customer customer){
        return customerDao.updateCustomerInfo(id, customer);
    }

    public Customer findUName(String name, String password){
        return customerDao.findUName(name, password);
    }
}
