package LAB;

import java.sql.*;

public class JDBCIntro {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemodb?createDatabaseIfNotExist=true";
    private static final String USER = "root";
    private static final String PASSWORD = "parola";

    public static void main(String[] args) throws SQLException {


        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("READY");

            // create table statement
            try (Statement statement = conn.createStatement()) {
                String query =
                        "CREATE TABLE IF NOT EXISTS users (" +
                                "id int AUTO_INCREMENT PRIMARY KEY," +
                                "username varchar(20)," +
                                "password varchar(20))";
                statement.executeUpdate(query);
            }

            // insert into table statement
//            try (Statement statement = conn.createStatement()) {
//                String query =
//                        "INSERT INTO users (username,password) " +
//                                "VALUES ('Ivan','123'), ('Gosho','abc')";
//                statement.executeUpdate(query);
//            }

            if (loginGood(conn, "Gosho", "abc")) {
                System.out.println("Login successful !");
            }
        }
    }

    private static boolean login(Connection connection, String user, String password) throws SQLException {          // this method will use the opened LAB.connection in our main method
        try (Statement statement = connection.createStatement()) {
            String query = "SELECT COUNT(id) " + "FROM users " +
                    "WHERE username='" + user + "' AND password='" + password
                    + "'";
            ResultSet rs = statement.executeQuery(query);
            rs.next();      // we have to execute 'next' to get first result

            int usersCount = rs.getInt(1); // start counting from 1
            return usersCount > 0; // return must stay in try construction
        }
    }

    private static boolean loginGood(Connection connection, String user, String password) throws SQLException {          // this method will use the opened LAB.connection in our main method
        String query = "SELECT COUNT(id) " + "FROM users " +
                "WHERE username= ? AND password= ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user);   // escaped
            statement.setString(2, password); // escaped
            ResultSet rs = statement.executeQuery();
            rs.next();      // we have to execute 'next' to get first result

            int usersCount = rs.getInt(1); // start counting from 1
            return usersCount > 0; // return must stay in try construction
        }
    }
}
