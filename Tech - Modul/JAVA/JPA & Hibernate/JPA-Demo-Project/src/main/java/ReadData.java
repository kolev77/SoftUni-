import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ReadData {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-db");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Query updatedPosts =
                    em.createQuery(
                            "FROM Post p JOIN FETCH p.author " +
                                    "WHERE p.title " +
                                    "LIKE CONCAT(:newTitle, '%') ")
                            .setParameter("newTitle", "Changed Title");
            List<Post> posts = updatedPosts.getResultList();

            for (Post post : posts) {
                System.out.println(post);
            }

            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}