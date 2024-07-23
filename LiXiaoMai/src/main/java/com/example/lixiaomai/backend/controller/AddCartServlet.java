package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Cart;
import com.example.lixiaomai.backend.entity.Customer;
import com.example.lixiaomai.backend.entity.Product;
import com.example.lixiaomai.backend.service.CartService;
import com.example.lixiaomai.backend.service.CustomerService;
import com.example.lixiaomai.backend.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String quantitiesParam = request.getParameter("quantities");
        String idsParam = request.getParameter("ids");
        String userName = request.getParameter("userId");

        if (quantitiesParam == null || idsParam == null) {
            response.sendRedirect("error.jsp");
            return;
        }

        CustomerService customerService = new CustomerService();
        Customer customer = customerService.getUserByUsername(userName);
        CartService cartService=new CartService();
        ProductService productService=new ProductService();
        Product product =new Product();

        int cId = customer.getId();
        Cart oldCart=cartService.getCartByCid(cId);


        List<Integer> gId = new ArrayList<>();
        List<Integer> goodsNum = new ArrayList<>();

        List<String> quantitiesList = Arrays.asList(quantitiesParam.replace("[", "").replace("]", "").split(","));
        List<String> idsList = Arrays.asList(idsParam.replace("[", "").replace("]", "").split(","));

        for (int i = 0; i < idsList.size(); i++) {
            gId.add(Integer.parseInt(idsList.get(i).trim().replace("\"","")));
            goodsNum.add(Integer.parseInt(quantitiesList.get(i).trim().replace("\"","")));
        }

        HttpSession session = request.getSession();
        Cart cart = new Cart();
        cart.setCId(cId);
        cart.setGId(gId);
        cart.setGoodsNum(goodsNum);
        double total=productService.calculateTotal(gId,goodsNum);
        cart.setTotal(total);
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
        boolean changed=cartService.updateCart(oldCart);
        response.sendRedirect("cart");
    }
}
