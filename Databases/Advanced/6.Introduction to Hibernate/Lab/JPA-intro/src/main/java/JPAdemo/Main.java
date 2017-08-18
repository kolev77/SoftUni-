package JPAdemo;

import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student goshi = new Student("Gosheiii",LocalDate.of(2014,2,4),15);
        Student peshi = new Student("Peshi",LocalDate.of(2014,2,4),21);

        em.persist(goshi);
        em.persist(peshi);

        em.remove(goshi);
        em.getTransaction().commit();
    }
}
