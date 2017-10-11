package service.api;

import entities.model.ProductionBatch;

public interface BatchService extends Service {
    void printBatch(ProductionBatch batch);
}
