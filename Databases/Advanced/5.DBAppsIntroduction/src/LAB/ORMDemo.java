package LAB;

import LAB.EntityManager.DBContext;
import LAB.EntityManager.EntityManager;
import LAB.model.User;

import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by Rostislav Kolev on 13-Jul-17.
 */
public class ORMDemo {
    public static void main(String[] args) throws SQLException, IllegalAccessException, NoSuchFieldException {
        DBContext em = new EntityManager();

        try {
            User user1 = new User("Ivan",25, LocalDate.now());
            em.persist(user1);
            user1.setAge(26);
            user1.setName("GOSHOOOOO");
            user1.setId(1);
            em.persist(user1);
        }finally {
                em.closeConnection();
        }
    }
}
