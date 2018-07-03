package org.softuni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            String URL = "jdbc:mysql://localhost:3306/servlets?createDatabaseIfNotExists=true&serverTimezone=UTC";
            String USER = "root";
            String PASS = "parola";

            try {
                Connection connection = DriverManager.getConnection(URL, USER, PASS);
                return connection;
            } catch (Exception e) {
                return null;
            }
        }

        return conn;
    }
}
