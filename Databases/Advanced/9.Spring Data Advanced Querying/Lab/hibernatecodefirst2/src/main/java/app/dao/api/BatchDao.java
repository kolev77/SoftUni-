package app.dao.api;

import app.entities.ProductionBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BatchDao extends JpaRepository<ProductionBatch, Long> {

    // Problem 5
    List<ProductionBatch> findByDateAfter(Date date);

    // Problem 9
    List<ProductionBatch> findAllByShampoosIsNull();
}
