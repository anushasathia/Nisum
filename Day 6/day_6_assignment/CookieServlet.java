import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        boolean found = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    out.println("<h3>Welcome back, " + cookie.getValue() + "!</h3>");
                    found = true;
                    break;
                }
            }
        }

      
        if (!found) {
            String username = "Anusha Sathia"; 
            Cookie userCookie = new Cookie("username", username);
            userCookie.setMaxAge(60 * 60 * 24);  
            response.addCookie(userCookie);

            out.println("<h3>Hello! A cookie has been set for you.</h3>");
        }

        out.println("<br><a href='CookieServlet'>Refresh</a> to test reading cookie.");
    }
}
