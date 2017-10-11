package app.dao.api;

import app.entities.BasicChemicalIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChemicalIngredientDao extends JpaRepository<BasicChemicalIngredient,Long> {
    List<BasicChemicalIngredient> findAllByChecmicalFormula(String checmicalFormula);
}
