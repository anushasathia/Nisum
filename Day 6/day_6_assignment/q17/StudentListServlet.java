import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/students")
public class StudentListServlet extends HttpServlet {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ServletDB";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "password";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        StringBuilder html = new StringBuilder("<h2>Students List</h2><table border='1'><tr><th>ID</th><th>Name</th><th>Age</th></tr>");

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, age FROM students")) {

            while (rs.next()) {
                html.append("<tr>")
                        .append("<td>").append(rs.getInt("id")).append("</td>")
                        .append("<td>").append(rs.getString("name")).append("</td>")
                        .append("<td>").append(rs.getInt("age")).append("</td>")
                        .append("</tr>");
            }

        } catch (SQLException e) {
            html.append("<tr><td colspan='3'>Error: ").append(e.getMessage()).append("</td></tr>");
        }
        html.append("</table>");
        resp.getWriter().write(html.toString());
    }
}
