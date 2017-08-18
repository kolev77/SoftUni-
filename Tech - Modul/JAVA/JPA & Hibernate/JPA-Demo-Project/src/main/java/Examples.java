import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by nakov on 28-Jul-16.
 */
public class Examples {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("blog-db");
        EntityManager em = emf.createEntityManager();
        try {
            User newUser = new User();
            newUser.setUsername("pesho");
            em.getTransaction().begin();
            em.persist(newUser);
            em.getTransaction().commit();
            System.out.println("Created new user #" + newUser.getId());
        }
        finally {
            em.close();
            emf.close();
        }

    }
}
