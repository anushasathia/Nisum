import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/firstServlet")
public class FirstServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
      
        request.setAttribute("message", "Hello from FirstServlet!");
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/secondServlet");
        
        dispatcher.forward(request, response);
    }
}

@WebServlet("/secondServlet")
public class SecondServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
      
        String msg = (String) request.getAttribute("message");
        
        response.setContentType("text/html");
        response.getWriter().println("<h2>Message received in SecondServlet: " + msg + "</h2>");
    }
}
