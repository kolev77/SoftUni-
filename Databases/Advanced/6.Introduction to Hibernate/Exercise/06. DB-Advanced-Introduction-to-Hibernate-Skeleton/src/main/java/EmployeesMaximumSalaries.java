import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EmployeesMaximumSalaries {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        List<Department> departments = em
                .createQuery("SELECT d FROM Department AS d " +
                        " JOIN d.employees AS e" +
                        " GROUP BY d HAVING MAX(e.salary) < 30000 OR MAX(e.salary)>70000")
                .getResultList();

        departments.forEach(d -> {
            System.out.printf("%s - %.2f\n",
                    d.getName(),
                    d.getEmployees()
                            .stream()
                            .sorted((e1, e2) -> e2.getSalary().compareTo(e1.getSalary()))
                            .limit(1)
                            .map(Employee::getSalary)
                            .findFirst().get());
        });
    }
}
