package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.stream.Stream;

public class IncreaseMinionsAge {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "parola";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputIds = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String updateMinionsQuery = "UPDATE minions " +
                "SET age = age + 1, " +
                "name = CONCAT(UPPER(LEFT(name,1)),SUBSTRING(name,2)) " +
                "WHERE minion_id in ( ";

        String getMinionsQuery = "SELECT name, age FROM minions;";

        for (int i = 0; i < inputIds.length - 1; i++) {
            updateMinionsQuery += inputIds[i] + ", ";
        }
        updateMinionsQuery += inputIds[inputIds.length - 1] + ") ";


        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement updateMinionsStatement = connection.createStatement();
            updateMinionsStatement.executeUpdate(updateMinionsQuery);

            Statement getMinionsStatement = connection.createStatement();
            ResultSet minions = getMinionsStatement.executeQuery(getMinionsQuery);

            while (minions.next()) {
                String name = minions.getString("name");
                int age = minions.getInt("age");
                System.out.println(name + " " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
