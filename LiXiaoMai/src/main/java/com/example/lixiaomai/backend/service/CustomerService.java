package com.example.lixiaomai.backend.service;

import com.example.lixiaomai.backend.dao.CustomerDao;
import com.example.lixiaomai.backend.entity.Customer;


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

    public boolean existCustomer(String username){
        return customerDao.findUserByUsername(username) != null;
    }

    public Customer findUName(String name, String password){
        return customerDao.findUName(name, password);
    }

    public boolean login(String username, String password){
        Customer customer = customerDao.findUserByUsername(username);
        return customer != null && customer.getPassword().equals(password);
    }
}
