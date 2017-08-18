import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RemoveObjects {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        List<Town> towns = em.createQuery("SELECT t from Town  as t ")
                .getResultList();

        for (Town town : towns) {
            if (town.getName().length() > 5) {
                em.detach(town);
            }
        }


        em.getTransaction().begin();

        for (Town town : towns) {
            if (em.contains(town)) {
                town.setName(town.getName().toLowerCase());
                em.persist(town);
            }
        }

        // using stream
//        towns.stream().filter(t-> em.contains(t))
//                .forEach(t-> {
//                    t.setName(t.getName().toLowerCase());
//                    em.persist(t);
//                });
//

        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
