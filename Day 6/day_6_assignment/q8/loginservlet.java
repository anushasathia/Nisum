import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // Hardcoded credentials
    private final String USERNAME = "admin";
    private final String PASSWORD = "pass123";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");

        if(USERNAME.equals(username) && PASSWORD.equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            response.getWriter().write("<h2>Login Successful!</h2>");
            response.getWriter().write("<p>Welcome, " + username + "</p>");
            response.getWriter().write("<a href='logout'>Logout</a>");
        } else {
            response.getWriter().write("<h2>Login Failed!</h2>");
            response.getWriter().write("<p>Invalid username or password.</p>");
            response.getWriter().write("<a href='login.html'>Try Again</a>");
        }
    }
}
