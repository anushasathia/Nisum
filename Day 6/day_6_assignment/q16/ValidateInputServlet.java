import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/validateInput")
public class ValidateInputServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String ageStr = request.getParameter("age");

        String message = "";

        // Basic validations
        if (name == null || name.trim().isEmpty()) {
            message = "Error: Name is required.";
        } else if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
            message = "Error: Enter a valid email address.";
        } else if (ageStr == null || !ageStr.matches("\\d+")) {
            message = "Error: Age must be a valid number.";
        } else {
            int age = Integer.parseInt(ageStr);
            if (age < 1 || age > 120) {
                message = "Error: Age must be between 1 and 120.";
            } else {
                message = "Success! User details are valid.<br>"
                        + "Name: " + name + "<br>"
                        + "Email: " + email + "<br>"
                        + "Age: " + age;
            }
        }

        response.setContentType("text/html");
        response.getWriter().println("<h2>" + message + "</h2>");
    }
}
