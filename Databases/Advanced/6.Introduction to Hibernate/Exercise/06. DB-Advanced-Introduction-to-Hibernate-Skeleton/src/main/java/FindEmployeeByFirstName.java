import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class FindEmployeeByFirstName {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String pattern = br.readLine()+"%";
        Query query = em.createQuery("SELECT e from Employee  AS e where " +
                "lower(e.firstName) LIKE lower(:pattern)");

        List<Employee> employees =  query.setParameter("pattern",pattern).getResultList();

        employees.forEach(e -> {
            System.out.println(String.format("%s %s - %s - ($%.2f)",
                    e.getFirstName(),
                    e.getLastName(),
                    e.getJobTitle(),
                    e.getSalary()));
        });

        em.close();
        emf.close();
    }
}
