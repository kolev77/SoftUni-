package app.dao.impl;

import app.dao.api.ShampooDaoCustom;
import app.entities.BasicIngredient;
import app.entities.BasicShampoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ShampooDaoImpl implements ShampooDaoCustom {
    private final EntityManager em;  // created and managed by Spring

    @Autowired
    public ShampooDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<BasicShampoo> findByIng(BasicIngredient bi) {
        List<BasicShampoo> allShampoos = em.createQuery("FROM BasicShampoo").getResultList();

        return allShampoos.stream()
                .filter(s-> s.getIngredients().contains(bi))
                .collect(Collectors.toList());
    }
}
