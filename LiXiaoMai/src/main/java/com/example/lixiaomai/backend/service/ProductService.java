package com.example.lixiaomai.backend.service;

import com.example.lixiaomai.backend.dao.ProductDao;
import com.example.lixiaomai.backend.entity.Product;

import java.util.List;

public class ProductService {

    static ProductDao productDao = new ProductDao();

    public List<Product> getAllProductBySId() {
        return productDao.getAllProductBySId();
    }

    public double calculateTotal(List<Integer> gIds, List<Integer> goodsNum) {
        double total = 0;
        for (int i = 0; i < gIds.size(); i++) {
            Product product = getProductById(gIds.get(i));
            total += product.getPrice() * goodsNum.get(i);
        }
        return total;
    }
    public List<Product> getAllProductBySid(int sId){
        return productDao.getAllProductBySid(sId);
    }

    public boolean updateProduct(Product product, int pId){
        return productDao.updateProduct(product, pId);
    }

    public boolean addProduct(Product product){
        return productDao.addProduct(product);
    }

    public Product getProductById(int id){
        return productDao.getProductById(id);
    }

    public boolean deleteProductById(int id){
        return productDao.deleteProductById(id);
    }
    public String getPictureUrl(int id){
        return productDao.getUrlById(id);
    }

}
