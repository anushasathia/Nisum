import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            resp.sendRedirect("login");
            return;
        }

        resp.setContentType("text/html");
        String username = (String) session.getAttribute("username");
        resp.getWriter().write("<h2>Welcome " + username + "</h2>");
        resp.getWriter().write("<a href='logout'>Logout</a>");
    }
}
