import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/set-session")
public class SetSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        
       
        session.setAttribute("username", "john_doe");
        session.setAttribute("role", "admin");
        
        resp.setContentType("text/html");
        resp.getWriter().println("<h2>Session Attributes Set</h2>");
        resp.getWriter().println("<p>Username: john_doe</p>");
        resp.getWriter().println("<p>Role: admin</p>");
        resp.getWriter().println("<a href='get-session'>Go to Read Session Servlet</a>");
    }
}
