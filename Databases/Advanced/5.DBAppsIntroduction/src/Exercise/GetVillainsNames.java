package Exercise;
import java.sql.*;

public class GetVillainsNames {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "parola";

    public static void main(String[] args) throws SQLException {
        String selectVillainQuery = "SELECT v.name, COUNT(*) AS 'minion_count' FROM villains AS `v` " +
                "INNER JOIN minions_villains AS `m_v` " +
                "ON v.villain_id = `m_v`.villain_id " +
                "GROUP BY v.name " +
                "HAVING minion_count > 3 " +
                "ORDER BY minion_count DESC;";
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement villainsStatement = connection.createStatement();
        ){
            ResultSet resultSet = villainsStatement.executeQuery(selectVillainQuery);

            while (resultSet.next()){
                String name = resultSet.getString("name");
                int counter = resultSet.getInt("minion_count");
                System.out.printf("%s %d\n",name,counter);
            }
            villainsStatement.close();
        }
    }
}
