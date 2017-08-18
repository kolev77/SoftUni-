package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChangeTownNamesCasing {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "parola";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String country = br.readLine();

        String updateTownsQuery = "UPDATE towns " +
                "SET name = upper(name) " +
                "WHERE country = ?;";

        String getTownNamesQuery = "SELECT name FROM towns " +
                "WHERE country = ?";


        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateTownsQuery);
            preparedStatement.setString(1, country);
            int townsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            if (townsAffected == 0) {
                System.out.println("No town names were affected.");
            } else {
                System.out.println(townsAffected + " town names were affected.");

                PreparedStatement getTwonsStatement = connection.prepareStatement(getTownNamesQuery);
                getTwonsStatement.setString(1, country);
                ResultSet townsResultSet = getTwonsStatement.executeQuery();

                List<String> result = new ArrayList<>();
                while (townsResultSet.next()) {
                    result.add(townsResultSet.getString("name"));
                }

                System.out.printf("[%s]", String.join(", ", result));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
