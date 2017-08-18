package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * Created by Rostislav Kolev on 15-Jul-17.
 */
public class GetMinionNames {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "parola";

    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int villainId = Integer.valueOf(br.readLine());

        String getVillainQuery = "SELECT v.name FROM `villains` as `v` " +
                "WHERE v.villain_id = ?;";

        String getMinionsQuery = "SELECT m.name, m.age FROM `minions` as `m` " +
                "INNER JOIN minions_villains AS mv " +
                "ON m.minion_id = mv.villain_id " +
                "WHERE mv.villain_id = ?;";


        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            try (PreparedStatement getVillainStatement = connection.prepareStatement(getVillainQuery)) {
                getVillainStatement.setInt(1, villainId);
                ResultSet villainRresultSet = getVillainStatement.executeQuery();
                villainRresultSet.next();
                String villainName = villainRresultSet.getString("name");
                getVillainStatement.close();
                System.out.printf("Villain: %s\n", villainName);

            } catch (SQLException e) {
                System.out.println("No villain with ID " + villainId + " exists in the database.");
                return;
            }

            PreparedStatement getMinionsStatement = connection.prepareStatement(getMinionsQuery);
            getMinionsStatement.setInt(1, villainId);
            ResultSet minionsResultSet = getMinionsStatement.executeQuery();
            int counter = 1;

            while (minionsResultSet.next()) {
                String minionName = minionsResultSet.getString("name");
                Integer minionAge = minionsResultSet.getInt("age");
                System.out.printf("%d. %s %d\n", counter++, minionName, minionAge);
            }
            getMinionsStatement.close();
            if (counter == 1)
                System.out.println("<no minions>");
        }
    }
}
