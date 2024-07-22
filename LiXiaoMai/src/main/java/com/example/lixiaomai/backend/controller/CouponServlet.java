package com.example.lixiaomai.backend.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import lombok.SneakyThrows;
import org.json.JSONException;
import org.json.JSONObject;

import static java.lang.System.out;

@WebServlet(urlPatterns = "/coupon")
public class CouponServlet extends HttpServlet {
    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json"); // 设置响应内容类型为JSON

        HttpSession session = request.getSession();

        // 读取请求体
        StringBuilder jsonStringBuilder = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                jsonStringBuilder.append(line);
            }
        }

        String jsonString = jsonStringBuilder.toString();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        // 从JSON对象中获取result
        String result = null;
        try {
            result = jsonObject.getString("result");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        // 打印结果到服务器控制台
        System.out.println("接收到的结果: " + result);

        // 设置响应内容
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "success");
        jsonResponse.put("message", "结果已接收");

        PrintWriter out = response.getWriter();
        out.print(jsonResponse.toString());
        out.flush();
    }
}
