import java.sql.*;

public class CallProcedureExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String password = "12345678";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            String query = "{CALL getStudentById(?)}";
            CallableStatement stmt = conn.prepareCall(query);
            stmt.setInt(1, 101); 

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

        } catch (SQLException e) {
            System.err.println("Error executing stored procedure: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.err.println("Error closing connection: " + ex.getMessage());
            }
        }
    }
}
