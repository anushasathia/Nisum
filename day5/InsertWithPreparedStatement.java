import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertWithPreparedStatement {
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
        Connection conn = getConnection();

        if (conn != null) {
            String insertQuery = "INSERT INTO students(id, name, age) VALUES (?, ?, ?)";

            try {
                PreparedStatement pstmt = conn.prepareStatement(insertQuery);

                pstmt.setInt(1, 1);                  
                pstmt.setString(2, "John Doe");      
                pstmt.setInt(3, 22);                 

                int rowsInserted = pstmt.executeUpdate();
                System.out.println(rowsInserted + " record(s) inserted successfully.");

                pstmt.close();
                conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.err.println("Error inserting data: " + e.getMessage());
            }
        }
    }
}
