package com.example.lixiaomai.backend.controller;

import com.example.lixiaomai.backend.entity.Business;
import com.example.lixiaomai.backend.entity.Cart;
import com.example.lixiaomai.backend.entity.Order;
import com.example.lixiaomai.backend.entity.Product;
import com.example.lixiaomai.backend.service.BusinessService;
import com.example.lixiaomai.backend.service.CartService;
import com.example.lixiaomai.backend.service.ProductService;
import com.example.lixiaomai.backend.tools.Tool;
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
        String name = (String) session.getAttribute("name");

        CartService cartService = new CartService();
        ProductService productService = new ProductService();

        Integer sId = Integer.parseInt(request.getParameter("sId"));
        List<Integer> gIds = Tool.StringToList(request.getParameter("gIds"), Integer.class);
        List<Integer> goodsNum = Tool.StringToList(request.getParameter("goodsNum"), Integer.class);
        List<Integer> discountIds = Tool.StringToList(request.getParameter("discountIds"), Integer.class);
        List<Integer> discountNum = Tool.StringToList(request.getParameter("discountNum"), Integer.class);





//        Map<Integer, List<Pair<Integer,Integer>>> map = cartService.diffProducts(cartService.getCartByCid(id));
//        BusinessService businessService = new BusinessService();
//        for (Map.Entry<Integer, List<Pair<Integer,Integer>>> entry : map.entrySet()) {
//            int sId = entry.getKey();
//            Business business = businessService.getBusinessById(sId);
//            List<Pair<Integer,Integer>> list = entry.getValue();
//            List<Integer> gIds = list.stream().map(Pair::getLeft).toList();
//            List<Integer> goodsNum = list.stream().map(Pair::getRight).toList();
//            Order order = new Order();
//
//
//            order.setGId(gIds);
//            order.setGoodsNum(goodsNum);
//            order.setCId(id);
//            order.setCName(name);
//            order.setSId(sId);
//            order.setSName(business.getName());
//
//
//
//
//
//
//        }




    }

}
