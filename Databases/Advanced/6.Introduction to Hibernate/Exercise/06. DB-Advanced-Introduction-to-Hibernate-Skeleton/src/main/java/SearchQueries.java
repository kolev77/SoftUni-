import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchQueries {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

//        firstTask(em);
//        secondTask(em);
//        thirdTask(em);
        fourthTask(em);

        em.close();
        emf.close();
    }


    public static void firstTask(EntityManager em) {
        List<Address> addresses = em
                .createQuery("SELECT DISTINCT a FROM Address AS a " +
                        "ORDER BY a.employees.size DESC , a.town.name ASC ")
                .setMaxResults(10)
                .getResultList();

        for (Address address : addresses) {
            System.out.println(String.format("%s, %s - %d employees",
                    address.getText(),
                    address.getTown().getName(),
                    address.getEmployees().size()));
        }
    }


    public static void secondTask(EntityManager em) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int id = Integer.parseInt(br.readLine());

        Employee employee = (Employee) em.createQuery("SELECT e FROM Employee AS e WHERE e.id = " + id).getSingleResult();
        System.out.println(String.format("%s %s - %s, Projects: %s.",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle(),
                String.join(", ", employee.getProjects().stream()
                        .map(Project::getName)
                        .sorted()
                        .collect(Collectors.toList()))));
    }

    public static void thirdTask(EntityManager em) {
        List<Employee> employees = em
                .createQuery("SELECT e FROM Employee AS e JOIN e.projects AS p " +
                        "WHERE DATE_FORMAT(p.startDate, '%Y') between 2001 and 2003")
                .getResultList();

        for (Employee e : employees) {
            System.out.println(String.format("%s %s, Manager: %s \nProjects:\n%s",
                    e.getFirstName(),
                    e.getLastName(),
                    e.getManager() == null ?
                            "no manager" : e.getManager().getFirstName() + " " + e.getManager().getLastName(),
                    e.getProjects().stream().map(p -> String.format("--- Name: %s, Start date: %s, End date: %s",
                            p.getName(),
                            p.getStartDate(),
                            p.getEndDate()))
                            .collect(Collectors.joining("\n"))));
        }
    }

    public static void fourthTask(EntityManager em){
        List<Department> departments = em.createQuery("SELECT d FROM Department AS d where " +
                "d.employees.size > 5 ORDER BY employees.size ASC").getResultList();

        System.out.println(departments.size());
        for (Department d : departments) {
            Set<Employee> employees = d.getEmployees();

            System.out.printf("--%s - Manager: %s, Employees: %d\n",
                    d.getName(),d.getManager().getLastName(), employees.size());
            employees.stream().forEach(e->
                    System.out.printf("%s %s hired date: %s, job title: %s\n",
                            e.getFirstName(),e.getLastName(),e.getHireDate(),e.getJobTitle()));

        }
    }
}