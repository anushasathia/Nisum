package com.nisum.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBconnection {
    private final String url = "jdbc:mysql://localhost:3306/project";
    private final String username = "root";
    private final String password = "123456789";


    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Connection is not successful", ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
