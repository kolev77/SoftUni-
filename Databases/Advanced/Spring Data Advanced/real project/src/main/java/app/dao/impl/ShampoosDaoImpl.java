package app.dao.impl;

import app.dao.api.ShampoosDaoCustom;
import app.model.BasicIngredient;
import app.model.BasicShampoos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ShampoosDaoImpl implements ShampoosDaoCustom {
    @Autowired
    private EntityManager em;

    @Override
    public List<BasicShampoos> findByIng(BasicIngredient bi) {
        List<BasicShampoos> allShampoos = em.createQuery("FROM BasicShampoos").getResultList();

        return allShampoos.stream()
                .filter(s->s.getIngredients().contains(bi))
                .collect(Collectors.toList());

    }
}
