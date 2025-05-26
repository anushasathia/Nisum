package com.nisum.controller;

import com.google.gson.Gson;
import com.nisum.dao.UserAddressesDAO;
import com.nisum.model.UserAddresses;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class UserAddressesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        UserAddressesDAO userAddressesDAO = new UserAddressesDAO();
        Gson gson = new Gson();
        resp.setContentType("application/json");
        if(idParam != null){
            int addressid = Integer.parseInt(idParam);
            UserAddresses userAddresses = userAddressesDAO.getAddressByAddressId(addressid);
            String json = gson.toJson(userAddresses);
            resp.getWriter().write(json);

        }else {

            ArrayList<UserAddresses> userAddressesArrayList = userAddressesDAO.getAddressByUserId(1);
            String json = gson.toJson(userAddressesArrayList);


            resp.getWriter().write(json);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}


