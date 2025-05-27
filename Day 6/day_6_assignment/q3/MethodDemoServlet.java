package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/method-demo")
public class MethodDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String input = request.getParameter("data");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>GET Request Received</h2>");
        if (input != null) {
            out.println("<p>You entered (GET): " + input + "</p>");
        } else {
            out.println("<p>No input received via GET.</p>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String input = request.getParameter("data");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>POST Request Received</h2>");
        if (input != null) {
            out.println("<p>You entered (POST): " + input + "</p>");
        } else {
            out.println("<p>No input received via POST.</p>");
        }
    }
}
