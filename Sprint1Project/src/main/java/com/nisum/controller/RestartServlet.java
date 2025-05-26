package com.nisum.controller;

import com.nisum.dao.CartItemDAO;
import com.nisum.dao.ShoppingCartDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestartServlet extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartItemDAO cartItemDAO = new CartItemDAO();
        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
        cartItemDAO.deleteAllCartItems();
        shoppingCartDAO.deleteAllShoppingCartItems();

    }
}

