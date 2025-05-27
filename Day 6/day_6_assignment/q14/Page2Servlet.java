package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Page2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        session.setAttribute("email", email);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Confirmation Page</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Thank you for submitting your info!</p>");
    }
}
