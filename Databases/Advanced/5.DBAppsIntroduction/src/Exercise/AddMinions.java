package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class AddMinions {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "parola";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] minionInfo = br.readLine().split("\\s");
        String minionName = minionInfo[1];
        Integer minionAge = Integer.parseInt(minionInfo[2]);
        String townName = minionInfo[3];
        String villainName = br.readLine().split("\\s")[1];

        String selectTownQuery = "SELECT * FROM towns WHERE name = ?";
        String selectVillainQuery = "SELECT * FROM villains WHERE name = ?";
        String selectMinionQuery = "SELECT * FROM minions WHERE name = ?";

        String insertTownQuery = "INSERT INTO towns(name) VALUE(?)";
        String insertVillainQuery = "INSERT INTO villains(name,evilness_factor) VALUE(?,'evil')";
        String insertMinionQuery = "INSERT INTO minions(name,age,town_id) VALUE(?,?,?)";
        String InsertMapTableQuery = "INSERT INTO minions_villains(minion_id,villain_id) VALUE(?,?)";

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement townStatement = connection.prepareStatement(selectTownQuery);
        ) {
            townStatement.setString(1, townName);
            ResultSet townResult = townStatement.executeQuery();
            // check if town exists

            if (!townResult.next()) { // add town if not exists
                PreparedStatement insertTownStatement = connection.prepareStatement(insertTownQuery);
                insertTownStatement.setString(1, townName);
                insertTownStatement.executeUpdate();
                System.out.printf("Town %s was added to the database.\n", townName);
                insertTownStatement.close();  // close statement
            }

            int townId = 0;
            townResult = townStatement.executeQuery();
            if (townResult.next()) {
                townId = townResult.getInt("town_id"); // get town id
            }
            townStatement.close();


            // check if villain exists
            PreparedStatement selectVillainStatement = connection.prepareStatement(selectVillainQuery);
            selectVillainStatement.setString(1, villainName);

            ResultSet villainResult = selectVillainStatement.executeQuery();

            if (!villainResult.next()) {
                PreparedStatement insertVillainStatement = connection.prepareStatement(insertVillainQuery);
                insertVillainStatement.setString(1, villainName);
                insertVillainStatement.executeUpdate();
                System.out.printf("Villain %s was added to the database.\n", villainName);
                insertVillainStatement.close();
            }

            int villainId = 0;
            villainResult = selectVillainStatement.executeQuery();
            if (villainResult.next()) {
                villainId = villainResult.getInt("villain_id");
            }
            selectVillainStatement.close();

            // add minion to database
            PreparedStatement insertMinionStatement = connection.prepareStatement(insertMinionQuery);
            insertMinionStatement.setString(1, minionName);
            insertMinionStatement.setInt(2, minionAge);
            insertMinionStatement.setInt(3, townId);
            insertMinionStatement.executeUpdate();
            insertMinionStatement.close();

            // get minion`s id
            PreparedStatement selectMinionStatement = connection.prepareStatement(selectMinionQuery);
            int minionId = 0;
            selectMinionStatement.setString(1, minionName);
            ResultSet minionResult = selectMinionStatement.executeQuery();
            if (minionResult.next()) {
                minionId = minionResult.getInt("minion_id");
            }
            selectMinionStatement.close();

            PreparedStatement insertMapTableStatement = connection.prepareStatement(InsertMapTableQuery);
            insertMapTableStatement.setInt(1,minionId);
            insertMapTableStatement.setInt(2,villainId);
            insertMapTableStatement.executeUpdate();
            System.out.printf("Successfully added %s to be minion of %s\n",minionName,villainName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
