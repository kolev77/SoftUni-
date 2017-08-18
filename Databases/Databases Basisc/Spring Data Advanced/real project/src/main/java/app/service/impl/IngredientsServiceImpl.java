package app.service.impl;

import app.dao.api.ChemicalIngredietsDao;
import app.dao.api.IngredientsDao;
import app.model.BasicChemicatIngredient;
import app.model.BasicShampoos;
import app.service.api.IngredientService;
import app.model.BasicIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by User on 18.7.2017 г..
 */
@Service
@Transactional
public class IngredientsServiceImpl implements IngredientService<BasicIngredient, Long> {

    @Autowired
    private IngredientsDao ingredientsDao;

    @Autowired
    private ChemicalIngredietsDao chemicalIngredietsDao;

    @Override
    public BasicIngredient findById(Long id) {
        return ingredientsDao.findOne(id);
    }

    @Override
    public void remove(BasicIngredient object) {
        ingredientsDao.delete(object);
    }

    @Override
    public List<BasicIngredient> findAll(Class<BasicIngredient> serviceClass) {
        return ingredientsDao.findAll();
    }

    @Override
    public void save(BasicIngredient object) {
        ingredientsDao.save(object);
    }

    @Override
    public List<BasicIngredient> findByNameEndsWith(String suffix) {
        return ingredientsDao.findByNameEndingWith(suffix);
    }

    @Override
    public List<BasicShampoos> shampoosWithIngredient(BasicIngredient ingredient) {
        return ingredientsDao.shampoosWithIngredient(ingredient);
    }

    @Override
    public List<BasicChemicatIngredient> findChemicalIngWithFormula(String formula) {
        return chemicalIngredietsDao.findByChemicalFormula(formula);
    }

    @Override
    public List<BasicIngredient> findByNameIn(@Param("namesList") List<String> names) {
        return ingredientsDao.findByNameIn(names);
    }
    @Override
    public void deleteByName(@Param("name") String name){
        ingredientsDao.deleteByName(name);
   }

   @Override
   public void updatePrice(){
       ingredientsDao.updatePrice();
   }

   @Override
   public List<BasicChemicatIngredient> findChemicalIngredient(String formula){
      return chemicalIngredietsDao.findByChemicalFormula(formula);
   }
}
