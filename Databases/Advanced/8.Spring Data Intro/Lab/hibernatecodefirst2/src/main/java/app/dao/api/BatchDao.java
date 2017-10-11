package app.dao.api;

import app.entities.model.ProductionBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchDao extends JpaRepository<ProductionBatch, Long> {

}
