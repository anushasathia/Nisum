import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession(false); 
        if (session != null) {
            session.invalidate();  
        }

        response.setContentType("text/html");
        response.getWriter().write("<h2>You have been logged out.</h2>");
        response.getWriter().write("<a href='login.html'>Login Again</a>");
    }
}
