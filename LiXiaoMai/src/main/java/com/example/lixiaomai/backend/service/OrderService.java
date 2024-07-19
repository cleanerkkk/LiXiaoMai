package com.example.lixiaomai.backend.service;

import com.example.lixiaomai.backend.dao.OrderDao;
import com.example.lixiaomai.backend.entity.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

public class OrderService {
    static OrderDao orderDao = new OrderDao();

    public List<Order> getAllOrderByCid(int cId){
        return orderDao.getAllOrderByCid(cId);
    }

    public List<Order> getAllOrderByDeliverId(int dId){
        return orderDao.getAllOrderByDeliverId(dId);
    }

    public List<Order> getAllOrderBySid(int sId){
        return orderDao.getAllOrderBySid(sId);
    }

    public boolean addOrder(Order order){
        return orderDao.addOrder(order);
    }

    public boolean updateOrder(Order order){
        return orderDao.updateOrder(order);
    }

    public boolean delOrderById(int id){
        return orderDao.delOrderById(id);
    }

    public Order getOrderById(int id){
        return orderDao.getOrderById(id);
    }
}