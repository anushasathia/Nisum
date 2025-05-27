package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user-data")
public class UserDataServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve data from form
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Response - content type 
        response.setContentType("text/html");

        //Output to the browser
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>User Information Received</h2>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("</body></html>");
    }
}
