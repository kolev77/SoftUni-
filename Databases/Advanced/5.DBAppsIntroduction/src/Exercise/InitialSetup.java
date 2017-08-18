package Exercise;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitialSetup {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "parola";

    public static void main(String[] args) {
        String createQuery = "CREATE DATABASE IF NOT EXISTS minions_db;";
        String useQuery = "USE minions_db";
        String createMinionTableQuery = "CREATE TABLE IF NOT EXISTS minions( " +
                "minion_id int PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50), " +
                "age int, " +
                "town_id INT, " +
                "FOREIGN KEY (town_id) REFERENCES towns(town_id));";

        String createTownsTableQuery = "CREATE TABLE IF NOT EXISTS towns( " +
                "town_id int PRIMARY KEY  AUTO_INCREMENT, "+
                "name VARCHAR(50), "
                + "country VARCHAR(50));";

        String createVillainsTable = "CREATE TABLE villains(villain_id INT PRIMARY KEY AUTO_INCREMENT, "+
                "name VARCHAR(50), "+
                "evilness_factor VARCHAR(20))";

        String createMapTableQuery = "CREATE TABLE minions_villains(minion_id INT, "+
                "villain_id INT," +
                "PRIMARY KEY (minion_id,villain_id),"+
                "FOREIGN KEY (minion_id) REFERENCES minions(minion_id),"+
                "FOREIGN KEY (villain_id) REFERENCES villains(villain_id))";


        String insertVillain = "INSERT INTO villains(name,evilness_factor) "+
                "VALUES ('Goshiii','good'),('Pesho','bad'),('Jimmy','evil'),('Jen','bad'),('Horse','super evil')";

        String insertMinions = "INSERT INTO minions(name,age,town_id) "+
                "VALUES ('Rob',5,1),('Sturd',4,3),('Gosho',8,5),('Ivan',2,4),('Muhlioto',1,2),('niki',16,3),('vankata',22,5)";

        String insertTowns = "INSERT INTO towns(name,country) "+
                "VALUES ('London','US'),('Sofia','Bulgaria'),('New York','USA'),('Paris','France'),('Rim','Italy')";

        String insertMaps ="INSERT INTO minions_villains "+
                "VALUES (1,3),(2,4),(5,1),(3,4),(4,2),(1,4),(4,4),(5,5),(4,5),(3,5),(2,5),(1,5)";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();) {

            statement.executeUpdate(createQuery);
            statement.executeQuery(useQuery);
            statement.executeUpdate(createTownsTableQuery);
            statement.executeUpdate(createMinionTableQuery);
            statement.executeUpdate(createVillainsTable);
            statement.executeUpdate(createMapTableQuery);


            statement.executeUpdate(insertVillain);
            statement.executeUpdate(insertTowns);
            statement.executeUpdate(insertMinions);
            statement.executeUpdate(insertMaps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
