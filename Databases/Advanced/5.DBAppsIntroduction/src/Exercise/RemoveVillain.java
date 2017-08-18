package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class RemoveVillain {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "parola";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int villainId = Integer.valueOf(br.readLine());

        String selectVillainQuery = "SELECT v.name FROM `villains` as `v` " +
                "WHERE v.villain_id = ?;";
        String deleteFromMapQuery = "DELETE FROM minions_villains WHERE villain_id = ?;";
        String deleteFromVillainQuery = "DELETE FROM villains WHERE villain_id = ?;";


        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement selectVillainStatement = connection.prepareStatement(selectVillainQuery);
            selectVillainStatement.setInt(1, villainId);
            ResultSet villainResultSet = selectVillainStatement.executeQuery();

            if (villainResultSet.next()) {
                String villainName = villainResultSet.getString("name");
                selectVillainStatement.close();
                // delete from MapTable
                PreparedStatement deleteFromMapStatement = connection.prepareStatement(deleteFromMapQuery);
                deleteFromMapStatement.setInt(1, villainId);
                int minionsReleased = deleteFromMapStatement.executeUpdate();
                deleteFromMapStatement.close();

                //Delete from villains table
                PreparedStatement deleteVillainStatement = connection.prepareStatement(deleteFromVillainQuery);
                deleteVillainStatement.setInt(1,villainId);
                deleteVillainStatement.executeUpdate();
                deleteVillainStatement.close();

                System.out.println(villainName + " was deleted.");
                System.out.println(minionsReleased + " minions released.");

            } else {
                System.out.println("No such villain was found.\n");
                selectVillainStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
