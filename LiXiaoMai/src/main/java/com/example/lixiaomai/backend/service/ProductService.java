package com.example.lixiaomai.backend.service;

import com.example.lixiaomai.backend.dao.ProductDao;
import com.example.lixiaomai.backend.entity.Product;

import java.util.List;

public class ProductService {

    static ProductDao productDao = new ProductDao();

    public double calculateTotal(List<Integer> gIds, List<Integer> goodsNum){
        return productDao.calculateTotal(gIds, goodsNum);
    }

    public List<Product> getAllProductBySid(int sId){
        return productDao.getAllProductBySid(sId);
    }

    public boolean updateProduct(Product product){
        return productDao.updateProduct(product);
    }

    public boolean addProduct(Product product){
        return productDao.addProduct(product);
    }

    public Product getProductById(int id){
        return productDao.getProductById(id);
    }


}
