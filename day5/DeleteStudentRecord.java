import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStudentRecord {
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();

        Connection connection = getConnection();

        if (connection != null) {
            String sql = "DELETE FROM students WHERE id = ?";

            try {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1, id);

                int rowsDeleted = pstmt.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Student record deleted successfully.");
                } else {
                    System.out.println("No student found with the given ID.");
                }

                pstmt.close();
                connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.err.println("Error while deleting: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
