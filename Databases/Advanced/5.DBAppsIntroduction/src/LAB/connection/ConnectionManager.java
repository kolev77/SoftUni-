package LAB.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {        // with 'final' this class is not allowed to be inherited
    private static final String URL = "jdbc:mysql://localhost:3306/miniHibernateDB?createDatabaseIfNotExist=true";
    private static final String USER = "root";
    private static final String PASSWORD = "parola";

    private ConnectionManager() {
    };
        // Like this, we cannot make an instance of this class

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
