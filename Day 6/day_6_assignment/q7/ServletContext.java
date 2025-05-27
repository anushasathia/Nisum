import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/context-demo")
public class ContextDemoServlet extends HttpServlet {

    private String appName;
    private String appVersion;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        appName = context.getInitParameter("appName");
        appVersion = context.getInitParameter("appVersion");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("<h2>Application Context Parameters</h2>");
        resp.getWriter().write("<p>Application Name: " + appName + "</p>");
        resp.getWriter().write("<p>Application Version: " + appVersion + "</p>");
    }
}
