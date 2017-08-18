import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by Rostislav on 2.8.2016 г..
 */
public class Seed {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-db");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            for (int i = 0; i < 10; i++) {
                User user = new User();
                user.setFullName("Georgi Goshev" + i);
                user.setUsername("gergo" + new Date().getTime());

                String passwordHash = BCrypt.hashpw("gosho"+ i, BCrypt.gensalt());
                user.setPasswordHash(passwordHash);

                em.persist(user);

                System.out.println("Created User" +user.getId());

                for (int j = 0; j < 5; j++) {

                    Post post = new Post();
                    post.setBody("New Post" + j);
                    post.setTitle("New Title" + i + j);
                    post.setAuthor(user);

                    em.persist(post);
                    System.out.println("Created Post" +post.getId());
                }
            }

            em.getTransaction().commit();



        }

        finally {
            em.close();
            emf.close();
        }
    }
}
