package Demo;

import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory sessionFactory =
                cfg.buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Student joro = new Student("Gosho", LocalDate.of(2015, 4, 15));
            Student Ivan = new Student("Ivan", LocalDate.of(2013, 1, 1));
//            session.persist(joro);
//            session.persist(Ivan);

//            Student student = session.get(Student.class, 2l);

            List goshovci = session.createQuery("SELECT s.name FROM Student as s WHERE s.name='Gosho'").list();
            goshovci.stream().forEach(g-> System.out.println(g));

            // Your Code Here
            session.getTransaction().commit();
        }
    }

}
