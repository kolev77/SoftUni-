package dao.impl;

import dao.api.Dao;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaDao<E,K> implements Dao {

    private EntityManager em;


    public JpaDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Object findById(Class entityClass, Object primaryKey) {
        return em.find(entityClass,primaryKey);
    }

    @Override
    public void remove(Object entity) {
            em.remove(entity);
    }

    @Override
    public List findAll(Class entityClass) {
        return em.createQuery("FROM "+ entityClass.getSimpleName()).getResultList();
    }

    @Override
    public void save(Object entity) {
        em.persist(entity);
    }
}
