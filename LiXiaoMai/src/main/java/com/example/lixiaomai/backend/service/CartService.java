package com.example.lixiaomai.backend.service;

import com.example.lixiaomai.backend.dao.CartDao;
import com.example.lixiaomai.backend.entity.Cart;
import com.example.lixiaomai.backend.entity.Product;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CartService {
    static CartDao cartDao = new CartDao();

    public Cart getCartByCid(int Cid) {
        return cartDao.getCartByCid(Cid);
    }

    public boolean updateCart(Cart cart) {
        return cartDao.updateCart(cart);
    }

    public boolean updateTotalBycId(Cart oldCart, double newTotal) {
        return cartDao.updateTotalBycId(oldCart, newTotal);
    }

    public Map<Integer, List<Pair<Product, Integer>>> diffProducts(Cart cart) {
        Map<Integer, List<Pair<Product, Integer>>> map = new HashMap<>();
        List<Integer> gIds = cart.getGId();
        ProductService productService = new ProductService();
        for (int i = 0; i < gIds.size(); i++) {
            Integer id = gIds.get(i);
            Integer cnt = cart.getGoodsNum().get(i);
            Product product = productService.getProductById(id);
            int sid = product.getSId();
            Pair<Product, Integer> pair = Pair.of(product, cnt);
            if (!map.containsKey(sid)) {
                List<Pair<Product, Integer>> list = new ArrayList<>();
                map.put(sid, list);
                map.get(sid).add(pair);
            } else {
                map.get(sid).add(pair);
            }
        }
        return map;
    }

    public boolean delProductByGId(int cId, int gId, int gNum) {
        boolean isUpdated;
        Cart cart = getCartByCid(cId);
        int index = cart.getGId().indexOf(gId);
        ProductService productService = new ProductService();
        if (index >= 0) {
            int oldNum = cart.getGoodsNum().get(index);
            if (oldNum > gNum) {
                cart.getGoodsNum().set(index, oldNum - gNum);
            } else {
                cart.getGId().remove(index);
                cart.getGoodsNum().remove(index);
            }
            cart.setTotal(cart.getTotal() - productService.calculateTotal(cart.getGId(), cart.getGoodsNum()));
            isUpdated = updateCart(cart);

        } else {
            isUpdated = false;
        }
        return isUpdated;
    }

    public boolean delProductByGIdList(int cid, List<Integer> gId, List<Integer> gNum) {
        boolean isUpdated = true;
        for (int i = 0; i < gId.size(); i++) {
            isUpdated = isUpdated && delProductByGId(cid, gId.get(i), gNum.get(i));

        }
        return isUpdated;
    }

    public boolean mergeTwoCarts(Cart oldCart, Cart cart) {
        List<Integer> gId;
        List<Integer> goodsNum;
        gId = cart.getGId();
        goodsNum = cart.getGoodsNum();
        double total = cart.getTotal();
        for (int i = 0; i < gId.size(); i++) {
            int index = oldCart.getGId().indexOf(gId.get(i));
            if (index >= 0) {
                // 如果商品已经存在，更新数量
                oldCart.getGoodsNum().set(index, oldCart.getGoodsNum().get(index) + goodsNum.get(i));
            } else {
                // 如果商品不存在，添加新的商品和数量
                oldCart.getGId().add(gId.get(i));
                oldCart.getGoodsNum().add(goodsNum.get(i));
            }
        }
        boolean changed1 = updateTotalBycId(oldCart, total);
        boolean changed = updateCart(oldCart);
        if (changed && changed1) {
            return true;
        }
        return false;
    }
}
