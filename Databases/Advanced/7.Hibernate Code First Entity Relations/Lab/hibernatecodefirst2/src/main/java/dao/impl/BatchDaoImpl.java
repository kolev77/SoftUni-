package dao.impl;

import dao.api.BatchDao;
import entities.model.ProductionBatch;

import javax.persistence.EntityManager;

public class BatchDaoImpl extends JpaDao implements BatchDao{

    public BatchDaoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public void printBatch(ProductionBatch batch) {
        System.out.println(batch);
    }
}
