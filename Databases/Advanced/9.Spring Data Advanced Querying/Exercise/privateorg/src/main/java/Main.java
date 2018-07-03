import entities.institutions.Administration;
import entities.institutions.Department;
import entities.positions.Chief;
import entities.positions.Employee;
import entities.positions.SuperiorEmployee;
import enums.EmployeePosition;
import org.hibernate.Session;
import services.ChiefService;
import services.SuperiorEmployeeService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
    private static EntityManager em = emf.createEntityManager();
    private static SuperiorEmployeeService superiorEmployeeService = new SuperiorEmployeeService(em);
    private static ChiefService chiefService = new ChiefService(em);

    public static void main(String[] args) {
//        seedMethod(emf,em);


        em.close();
        emf.close();

    }

    private static void seedMethod(EntityManagerFactory emf, EntityManager em) {

        em.getTransaction().begin();

        Department department = new Department();
        Department d2epartment = new Department();
        Employee gosho = new Employee();
        gosho.setFirstName("Gosho");
        gosho.setLastName("Goshev");
        gosho.setAge(25);
        gosho.setEgn("8503449878");
        gosho.setPosition(EmployeePosition.EMPLOYEE);

        Employee pesho = new Employee();
        pesho.setFirstName("Pesho");
        pesho.setLastName("Goshev");
        pesho.setAge(25);
        pesho.setEgn("8503059878");
        pesho.setPosition(EmployeePosition.EMPLOYEE);

        Set<Employee> employees = new HashSet<>();
        employees.add(pesho);
        employees.add(gosho);
        em.persist(gosho);
        em.persist(pesho);
        department.setEmployees(employees);
        SuperiorEmployee theBoss = new SuperiorEmployee();
        theBoss.setFirstName("Venci");
        theBoss.setLastName("Ivanov");
        theBoss.setAge(25);
        theBoss.setEgn("9494922492");
        theBoss.setPosition(EmployeePosition.SUPERIOR);
        theBoss.setManagedDepartment(department);
        department.setHeadOfDepartment(theBoss);


        Administration administration = new Administration();
        Set<Department> departments = new HashSet<>();

        departments.add(department);
        administration.setDepartments(departments);
        department.setAdministration(administration);
        Chief chief = new Chief();
        chief.setManagedAdministration(administration);
        administration.setChief(chief);
        em.persist(theBoss);
        em.persist(administration);
        em.persist(chief);

        em.getTransaction().commit();
    }
}