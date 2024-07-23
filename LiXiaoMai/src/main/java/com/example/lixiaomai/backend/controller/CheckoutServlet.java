package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Cart;
import com.example.lixiaomai.backend.service.CartService;
import org.apache.commons.lang3.tuple.Pair;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute("id");
        CartService cartService = new CartService();

        Map<Integer, List<Pair<Integer,Integer>>> map = cartService.diffProducts(cartService.getCartByCid(id));

        for (Map.Entry<Integer, List<Pair<Integer,Integer>>> entry : map.entrySet()) {
            int sId = entry.getKey();
            List<Pair<Integer,Integer>> list = entry.getValue();
        }




    }

}
