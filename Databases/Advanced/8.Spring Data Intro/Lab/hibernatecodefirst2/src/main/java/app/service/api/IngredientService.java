package app.service.api;

import app.entities.model.BasicIngredient;
import java.util.List;

public interface IngredientService  {

    BasicIngredient findById(Long id);

    void remove(BasicIngredient object);

    List<BasicIngredient> findAll();

    void save(BasicIngredient object);

    List<BasicIngredient> findByNameEndingWith(String suffix);
}
