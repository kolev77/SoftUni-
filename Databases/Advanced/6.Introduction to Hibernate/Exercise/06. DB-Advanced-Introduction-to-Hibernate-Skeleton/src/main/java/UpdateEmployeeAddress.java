import entities.Address;
import entities.Employee;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpdateEmployeeAddress {
    public static void main(String[] args) throws IOException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        Address newAddress = new Address();
        newAddress.setText("Vitoshka 15");

        em.getTransaction().begin();
        Employee nakov = (Employee) em.createQuery("SELECT e FROM Employee  AS e WHERE e.lastName = 'Nakov'").getSingleResult();
        em.persist(newAddress);
        nakov.setAddress(newAddress);
        em.persist(nakov);
        em.getTransaction().commit();

        Query query = em.createQuery("SELECT e FROM Employee AS e WHERE e.lastName = 'Nakov'");
        Employee employee = (Employee) query.getSingleResult();
        System.out.println(employee.getAddress().getText());

        em.close();
        emf.close();


    }
}
