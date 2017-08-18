import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UpdateData {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-db");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Query goshoPosts =
                    em.createQuery(
                            "FROM Post p JOIN FETCH p.author " +
                                    "WHERE p.author.username " +
                                    "LIKE CONCAT(:username, '%') ")
                            .setParameter("username", "gergo14701766");
            List<Post> posts = goshoPosts.getResultList();

            for (Post post : posts) {
                post.setTitle("Changed Title " + post.getTitle());

            }

            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}