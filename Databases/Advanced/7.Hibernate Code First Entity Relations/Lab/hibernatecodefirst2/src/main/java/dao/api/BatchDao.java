package dao.api;

import entities.model.ProductionBatch;

public interface BatchDao extends Dao {
    void printBatch(ProductionBatch batch);
}
