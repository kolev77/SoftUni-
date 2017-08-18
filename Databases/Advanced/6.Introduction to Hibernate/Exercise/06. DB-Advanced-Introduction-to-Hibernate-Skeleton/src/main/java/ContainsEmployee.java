import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContainsEmployee {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        String employeeName = br.readLine();
        try {
            Employee employee = (Employee) em.createQuery("SELECT e FROM Employee AS e WHERE" +
                    " CONCAT(e.firstName,' ',e.lastName) = '"+employeeName+"'")
                    .getSingleResult();
            System.out.println("Yes");
        }catch (NoResultException e){
            System.out.println("No");
        }
        em.close();
        emf.close();
    }
}
