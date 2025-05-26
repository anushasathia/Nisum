package com.nisum.controller;

import com.google.gson.Gson;
import com.nisum.dao.ShoppingCartDAO;
import com.nisum.model.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShoppingCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
        ShoppingCart shoppingCart = shoppingCartDAO.getShoppingCartByUserID(1);
        Gson gson = new Gson();
        String json = gson.toJson(shoppingCart);

        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }
}
