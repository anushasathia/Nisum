import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStudentName {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String password = "12345678";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully!");
            return conn;
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();

        if (connection != null) {
            try {
                String updateQuery = "UPDATE students SET name = ? WHERE id = ?";
                PreparedStatement pstmt = connection.prepareStatement(updateQuery);

                pstmt.setString(1, "Jane Smith");  
                pstmt.setInt(2, 1);                

                int rowsUpdated = pstmt.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Student name updated successfully!");
                } else {
                    System.out.println("No student found with the given ID.");
                }

                pstmt.close();
                connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
