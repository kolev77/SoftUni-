package service.impl;

import app.Transactions.VoidCommand;
import dao.api.BatchDao;
import dao.api.Dao;
import dao.impl.BatchDaoImpl;
import entities.model.ProductionBatch;
import service.api.BatchService;

public class BatchServiceImpl extends ServiceImpl implements BatchService {
    @Override
    public void printBatch(ProductionBatch batch) {
        runInTransaction(new VoidCommand() {
            @Override
            public void execute() {
                ((BatchDao)dao).printBatch(batch);
            }
        });
    }

    @Override
    protected Dao createDao() {
        return new BatchDaoImpl(em);
    }
}
