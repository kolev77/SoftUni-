import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeBySalary {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        List<String> employeeNames = em.createQuery("SELECT e.firstName FROM Employee AS e WHERE e.salary > 50000").getResultList();

        for (String employeeName : employeeNames) {
            System.out.println(employeeName);
        }

        em.close();
        emf.close();
    }
}
