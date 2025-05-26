package com.nisum.controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.nisum.dao.CartItemDAO;
import com.nisum.dao.InitialCartItemDAO;
import com.nisum.model.CartItem;
import com.nisum.service.CartItemService;

public class CartItemServlet extends HttpServlet {

    // Handle GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CartItemDAO cartItemDAO = new CartItemDAO();
        ArrayList<CartItem> cartItemArrayList = cartItemDAO.getAllCartItems();
        Gson gson = new Gson();
        String json = gson.toJson(cartItemArrayList);

        response.setContentType("application/json");
        response.getWriter().write(json);

    }
    // Handle POST requests
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try(BufferedReader reader = request.getReader()){
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            Integer id = jsonObject.get("cartitemid").getAsInt();
            CartItemService cartItemService = new CartItemService();
           InitialCartItemDAO initialCartItemDAO = new InitialCartItemDAO();
           CartItemDAO cartItemDAO = new CartItemDAO();
            CartItem cartItem = initialCartItemDAO.getCartItemByCartItemID(id);
            cartItemDAO.addItems(cartItem);
            cartItemService.addCartItemToShoppingCart(cartItem);
            response.getWriter().write("Success");
        } catch (RuntimeException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JSON");
        }

    }
}
