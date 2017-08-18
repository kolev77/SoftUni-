import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;

public class CreateObjects {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        createObjects(em);

        em.getTransaction().commit();


        em.close();
    }

    public static void createObjects(EntityManager em){
        Employee manager = (Employee) em.createQuery("SELECT e FROM Employee AS e where e.id = 1").getResultList().toArray()[0];


        Department trainingDep = new Department();
        trainingDep.setManager(manager);

        trainingDep.setName("Department Training");
        Town burgas = new Town();
        burgas.setName("Burgas");

        Address address1 = new Address();;
        Address address2 = new Address();
        Address address3 = new Address();

        address1.setTown(burgas);
        address2.setTown(burgas);
        address3.setTown(burgas);

        address1.setText("Beach bar ");
        address2.setText("Mania ");
        address3.setText("Just Bar");

        Employee pesho = new Employee();
        pesho.setFirstName("Pesho");
        pesho.setManager(manager);
        pesho.setDepartment(trainingDep);
        pesho.setJobTitle("Java Dev");
        pesho.setAddress(address3);
        pesho.setSalary(new BigDecimal("5000"));
        pesho.setHireDate(new Timestamp(new Date().getTime()));  // java util date


        Employee gosho = new Employee();
        gosho.setFirstName("Gosho");
        gosho.setManager(manager);
        gosho.setAddress(address1);
        gosho.setDepartment(trainingDep);
        gosho.setJobTitle("Java DB");
        gosho.setSalary(new BigDecimal("2500"));
        gosho.setHireDate(new Timestamp(new Date().getTime()));  // java util date

        Employee maria = new Employee();
        maria.setFirstName("Marche");
        maria.setManager(manager);
        maria.setAddress(address2);
        maria.setDepartment(trainingDep);
        maria.setJobTitle("C++");
        maria.setSalary(new BigDecimal("3400"));
        maria.setHireDate(new Timestamp(new Date().getTime()));  // java util date




        em.persist(trainingDep);
        em.persist(burgas);
        em.persist(address1);
        em.persist(address2);
        em.persist(address3);
        em.persist(gosho);
        em.persist(pesho);
        em.persist(maria);
        em.persist(manager);
    }
}
