package app.service.api;


import app.entities.ProductionBatch;

import java.sql.Date;
import java.util.List;

public interface BatchService {
    void save(ProductionBatch object);
    // Problem 5
    List<ProductionBatch> findByDateAfter(Date date);

    // Problem 9
    List<ProductionBatch> findAllByShampoosIsNull();
}
