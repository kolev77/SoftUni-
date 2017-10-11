package app.dao.api;

import app.entities.model.BasicIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientDao extends JpaRepository<BasicIngredient, Long> {

    List<BasicIngredient> findByNameEndingWith(String suffix);
}
