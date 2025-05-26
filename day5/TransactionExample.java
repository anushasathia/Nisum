import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo"; 
        String user = "root"; 
        String password = "12345678"; 

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
          
            conn.setAutoCommit(false);

            String insertStudent = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
            PreparedStatement stmt1 = conn.prepareStatement(insertStudent);
            stmt1.setInt(1, 101);
            stmt1.setString(2, "Arjun");
            stmt1.setInt(3, 22);
            stmt1.executeUpdate();

            String insertLog = "INSERT INTO logs (student_id, action) VALUES (?, ?)";
            PreparedStatement stmt2 = conn.prepareStatement(insertLog);
            stmt2.setInt(1, 101);
            stmt2.setString(2, "Student Added");
            stmt2.executeUpdate();

           
            conn.commit();
            System.out.println("Both records inserted successfully.");

        } catch (SQLException e) {
            System.err.println("Transaction failed: " + e.getMessage());
            try {
                if (conn != null) {
                    conn.rollback(); 
                    System.out.println("Transaction rolled back.");
                }
            } catch (SQLException rollbackEx) {
                System.err.println("Rollback failed: " + rollbackEx.getMessage());
            }
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException closeEx) {
                System.err.println("Connection closing failed: " + closeEx.getMessage());
            }
        }
    }
}
