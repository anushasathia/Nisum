import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {
    private List<String> feedbackList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        StringBuilder sb = new StringBuilder("<h2>Feedbacks</h2><ul>");
        for (String feedback : feedbackList) {
            sb.append("<li>").append(feedback).append("</li>");
        }
        sb.append("</ul><a href='feedback.html'>Add More Feedback</a>");
        resp.getWriter().write(sb.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String feedback = req.getParameter("feedback");
        if (feedback != null && !feedback.trim().isEmpty()) {
            feedbackList.add(feedback);
        }
        resp.sendRedirect("feedback");
    }
}
