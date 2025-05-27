import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/config-demo")
public class ConfigDemoServlet extends HttpServlet {

    private String username;
    private String password;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        username = config.getInitParameter("username");
        password = config.getInitParameter("password");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("<h2>Initialization Parameters</h2>");
        resp.getWriter().write("<p>Username: " + username + "</p>");
        resp.getWriter().write("<p>Password: " + password + "</p>");
    }
}
