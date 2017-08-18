import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeFromSeatle {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        List<Employee> employeeNames = em.createQuery("SELECT e FROM Employee AS e WHERE e.department.name = 'Research and Development' ORDER BY e.salary ASC,e.firstName DESC").getResultList();

        for (Employee employee : employeeNames) {
            System.out.println(employee.getFirstName()+ " " + employee.getLastName() + " - " + employee.getDepartment().getName());
        }

        em.close();
        emf.close();
    }
}
