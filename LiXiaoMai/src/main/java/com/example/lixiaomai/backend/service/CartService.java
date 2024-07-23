package com.example.lixiaomai.backend.service;

import com.example.lixiaomai.backend.dao.CartDao;
import com.example.lixiaomai.backend.entity.Cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.lixiaomai.backend.entity.Product;
import org.apache.commons.lang3.tuple.Pair;


public class CartService {
    static CartDao cartDao = new CartDao();

    public Cart getCartByCid(int Cid){
        return cartDao.getCartByCid(Cid);
    }

    public boolean updateCart(Cart cart){
        return cartDao.updateCart(cart);
    }

    public Map<Integer, List<Pair<Product,Integer>>> diffProducts(Cart cart){
        Map<Integer,List<Pair<Product,Integer>>> map = new HashMap<>();
        List<Integer> gIds = cart.getGId();
        ProductService productService = new ProductService();
        for (int i = 0; i < gIds.size(); i++){
            Integer id = gIds.get(i);
            Integer cnt = cart.getGoodsNum().get(i);
            Product product = productService.getProductById(id);
            int sid = product.getSId();
            Pair<Product,Integer> pair = Pair.of(product,cnt);
            if (!map.containsKey(sid)) {
                List<Pair<Product,Integer>> list = new ArrayList<>();
                map.put(sid, list);
                map.get(sid).add(pair);
            }
            else{
                map.get(sid).add(pair);
            }
        }
        return map;
    }
}
