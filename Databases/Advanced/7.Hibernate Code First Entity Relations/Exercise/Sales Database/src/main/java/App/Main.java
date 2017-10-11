package App;

import entities.Customer;
import entities.Product;
import entities.Sale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//        seed(em);
        Customer customer = em.find(Customer.class, 1l);
        Set<Sale> sales = customer.getSales();


        em.getTransaction().commit();

        emf.close();
    }

    public static void seed(EntityManager em){
        Product laptop = new Product();
        laptop.setName("Lenovo");
        laptop.setPrice(BigDecimal.valueOf(2200));
        Product macBook = new Product();
        macBook.setName("Apple MacBook");
        macBook.setPrice(BigDecimal.valueOf(3500));
        Product samsung = new Product();
        samsung.setName("Samsung Note 6");
        samsung.setPrice(BigDecimal.valueOf(1700));
        // -------------------
        em.persist(laptop);
        em.persist(macBook);
        em.persist(samsung);
        // seed products


        Customer pesho = new Customer();
        pesho.setName("Pesho");
        pesho.setCreditCardNumber("123123123121");
        pesho.setEmail("pesho@mail.bg");
        Customer gosho = new Customer();
        gosho.setName("Gosho");
        gosho.setCreditCardNumber("1231412423121");
        gosho.setEmail("gosho@mail.bg");

        em.persist(pesho);
        em.persist(gosho);
        // seed customers

        Sale s1 = new Sale();
        s1.setCustomer(pesho);
        s1.setDate(Date.from(Instant.now()));
        s1.setProduct(laptop);

        Sale s2 = new Sale();
        s2.setCustomer(pesho);
        s2.setDate(Date.from(Instant.now()));
        s2.setProduct(macBook);

        Sale s3 = new Sale();
        s3.setCustomer(pesho);
        s3.setDate(Date.from(Instant.now()));
        s3.setProduct(samsung);
        em.persist(s1);
        em.persist(s2);
        em.persist(s3);
        // seed sales

    }
}
