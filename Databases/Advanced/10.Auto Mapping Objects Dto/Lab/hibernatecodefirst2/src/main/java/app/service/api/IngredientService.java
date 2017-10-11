package app.service.api;

import app.entities.BasicChemicalIngredient;
import app.entities.BasicIngredient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface IngredientService  {

    BasicIngredient findById(Long id);

    void remove(BasicIngredient object);

    List<BasicIngredient> findAll();

    void save(BasicIngredient object);

    List<BasicIngredient> findByNameEndingWith(String suffix);

    //Problem 8
    List<BasicIngredient> findAllByNameInOrderByPriceAsc(Collection<String> name);

    //Problem 12
    List<BasicIngredient> findByNameIn(@Param("namesList") List<String> names);

    //Problem 21
    void deleteIngByName(@Param("name")String name);

    //Problem 22
    void updateIngPrice();

    List<BasicChemicalIngredient> findAllByChecmicalFormula(String checmicalFormula);
}
