package com.example.lixiaomai.backend.service;

import com.example.lixiaomai.backend.dao.CartDao;
import com.example.lixiaomai.backend.entity.Cart;

public class CartService {
    static CartDao cartDao = new CartDao();

    public Cart getCartByCid(int Cid){
        return cartDao.getCartByCid(Cid);
    }

    public boolean updateCart(Cart cart){
        return cartDao.updateCart(cart);
    }
}
