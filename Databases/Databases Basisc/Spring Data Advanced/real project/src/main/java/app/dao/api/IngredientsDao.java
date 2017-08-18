package app.dao.api;

import app.model.BasicIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 18.7.2017 г..
 */

public interface IngredientsDao extends JpaRepository<BasicIngredient, Long>, IngedientsDaoCustom {
    List<BasicIngredient> findByNameEndingWith(String suffix);

    @Query(value = "SELECT bi FROM BasicIngredient AS bi WHERE bi.name IN :namesList")
    List<BasicIngredient> findByNameIn(@Param("namesList") List<String> names);

    @Modifying
    void deleteByName(@Param("name") String name);

    @Modifying
    void updatePrice();
}
