package app.dao.api;

import app.entities.model.BasicIngredient;
import app.entities.model.BasicShampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShampooDao extends JpaRepository<BasicShampoo, Long> {

    @Query("SELECT s FROM BasicShampoo AS s INNER JOIN s.ingredients as i WHERE i = :ing")
    List<BasicShampoo> shampooByIngredient(@Param("ing") BasicIngredient ingredient);
}
