package com.nisum;
import java.sql.*;

class DBConnection{
    private static String url = "jdbc:mysql://localhost:3306/DAY3";
    private static String username = "root";
    private static String password = "123456789";

    public Connection getConnection(){
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is successful");
            return con;
        }catch (SQLException ex) {
            System.out.println("There is some error in connection");
            ex.printStackTrace();
            return null;
        }
    }
}


public class App {
    public static void main(String[] args) {
    DBConnection db = new DBConnection();
    Connection conn = db.getConnection();

    Student newstd = Student.getStudent(conn,1);
    System.out.println(newstd.getFirstname());


    }
}
