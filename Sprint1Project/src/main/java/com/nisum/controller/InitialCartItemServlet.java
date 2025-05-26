package com.nisum.controller;

import com.google.gson.Gson;
import com.nisum.dao.InitialCartItemDAO;
import com.nisum.model.CartItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class InitialCartItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        InitialCartItemDAO initialCartItemDAO = new InitialCartItemDAO();
        ArrayList<CartItem> initialCartItemsList = initialCartItemDAO.getAllCartItems();

        Gson gson = new Gson();
        String json = gson.toJson(initialCartItemsList);

        resp.setContentType("application/json");
        resp.getWriter().write(json);

    }


}
