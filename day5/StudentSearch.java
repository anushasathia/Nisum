import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentSearch {

    private static Connection establishConnection() {
        String dbURL = "jdbc:mysql://localhost:3306/jdbcdemo"; 
        String username = "root";
        String password = "12345678";

        try {
            return DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException e) {
            System.out.println("Unable to connect to database: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the starting letters of the student name: ");
        String searchTerm = input.nextLine();

        Connection conn = establishConnection();

        if (conn != null) {
            String sql = "SELECT * FROM students WHERE name LIKE ?";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, searchTerm + "%");

                ResultSet result = stmt.executeQuery();

                boolean matchFound = false;
                while (result.next()) {
                    int studentId = result.getInt("id");
                    String studentName = result.getString("name");
                    int studentAge = result.getInt("age");

                    System.out.println("ID: " + studentId + ", Name: " + studentName + ", Age: " + studentAge);
                    matchFound = true;
                }

                if (!matchFound) {
                    System.out.println("No matching records found for input: " + searchTerm);
                }

                result.close();
                stmt.close();
                conn.close();

            } catch (SQLException e) {
                System.out.println("Error executing query: " + e.getMessage());
            }
        }

        input.close();
    }
}
