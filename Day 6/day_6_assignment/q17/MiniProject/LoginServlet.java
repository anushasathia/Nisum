import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final String USERNAME = "admin";
    private final String PASSWORD = "password123";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("<form method='post'>" +
                "Username: <input name='username' required /><br>" +
                "Password: <input type='password' name='password' required /><br>" +
                "<input type='submit' value='Login' />" +
                "</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("dashboard");
        } else {
            resp.getWriter().write("<h3>Invalid credentials. Try again.</h3>");
            doGet(req, resp);
        }
    }
}
