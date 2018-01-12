package app.service.api;

import app.model.BasicChemicatIngredient;
import app.model.BasicIngredient;
import app.model.BasicShampoos;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by User on 18.7.2017 г..
 */
public interface IngredientService<BasicIngredient, Long> extends ServiceInterface<BasicIngredient, Long> {
    List<app.model.BasicIngredient> findByNameEndsWith (String suffix);
    List<BasicShampoos> shampoosWithIngredient(BasicIngredient ingredient);

    List<BasicChemicatIngredient> findChemicalIngWithFormula(String formula);

    List<app.model.BasicIngredient> findByNameIn(@Param("namesList") List<String> names);

    void deleteByName(@Param("name") String name);

    void updatePrice();

    List<BasicChemicatIngredient> findChemicalIngredient(String formula);
}
