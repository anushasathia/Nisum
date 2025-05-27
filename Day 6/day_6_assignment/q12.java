import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {

    private static List<String> feedbackList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        resp.getWriter().println("<h2>User Feedback Form</h2>");
        resp.getWriter().println("<form method='post' action='feedback'>");
        resp.getWriter().println("Feedback: <input type='text' name='feedback' required>");
        resp.getWriter().println("<input type='submit' value='Submit'>");
        resp.getWriter().println("</form>");

       
        resp.getWriter().println("<h3>All Feedbacks:</h3>");
        if (feedbackList.isEmpty()) {
            resp.getWriter().println("<p>No feedback submitted yet.</p>");
        } else {
            resp.getWriter().println("<ul>");
            for (String fb : feedbackList) {
                resp.getWriter().println("<li>" + fb + "</li>");
            }
            resp.getWriter().println("</ul>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String feedback = req.getParameter("feedback");

       
        if (feedback != null && !feedback.trim().isEmpty()) {
            feedbackList.add(feedback.trim());
        }
      
        resp.sendRedirect("feedback");
    }
}
