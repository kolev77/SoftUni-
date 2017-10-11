package JPAdemo;

import entities.BasicIngredient;
import entities.Mint;
import entities.Strawberry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShampooCompany");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        BasicIngredient mint = new Mint();
        BasicIngredient doubleMint = new Mint();
        doubleMint.setPrice(BigDecimal.valueOf(1));
        BasicIngredient strawberry = new Strawberry();
        em.persist(mint);
        em.persist(doubleMint);
        em.persist(strawberry);
        em.getTransaction().commit();


    }
}
