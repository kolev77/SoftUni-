import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;

public class FindLatest10Projcets {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        List<Project> projects = em.createQuery(
                "SELECT p FROM Project AS p order by  p.name asc,p.startDate DESC").setMaxResults(10).getResultList();

        projects
                .stream()
//                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(p -> System.out.println(String.format("-- Name: %s Description: %s Start date: %s End date: %s",
                        p.getName(),
                        p.getDescription(),
                        p.getStartDate(),
                        p.getEndDate())));
    }


}
