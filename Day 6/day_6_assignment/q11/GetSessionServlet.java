import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/get-session")
public class GetSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false); 
        
        resp.setContentType("text/html");
        
        if (session == null) {
            resp.getWriter().println("<h2>No session found. Please set session attributes first.</h2>");
        } else {
            String username = (String) session.getAttribute("username");
            String role = (String) session.getAttribute("role");
            
            if (username == null || role == null) {
                resp.getWriter().println("<h2>Session attributes not found.</h2>");
            } else {
                resp.getWriter().println("<h2>Session Attributes</h2>");
                resp.getWriter().println("<p>Username: " + username + "</p>");
                resp.getWriter().println("<p>Role: " + role + "</p>");
            }
        }
        
        resp.getWriter().println("<a href='set-session'>Go to Set Session Servlet</a>");
    }
}
