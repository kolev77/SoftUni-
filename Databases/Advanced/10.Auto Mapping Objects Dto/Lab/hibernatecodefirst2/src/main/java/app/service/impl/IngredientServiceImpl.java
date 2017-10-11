package app.service.impl;

import app.dao.api.ChemicalIngredientDao;
import app.dao.api.IngredientDao;
import app.entities.BasicChemicalIngredient;
import app.entities.BasicIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import app.service.api.IngredientService;

import java.util.Collection;
import java.util.List;
@Service
@Transactional
public class IngredientServiceImpl implements IngredientService {

    private final IngredientDao ingredientDao;

    private ChemicalIngredientDao chemicalIngredientDao;

    @Autowired
    public IngredientServiceImpl(IngredientDao ingredientDao, ChemicalIngredientDao chemicalIngredientDao) {
        this.ingredientDao = ingredientDao;
        this.chemicalIngredientDao = chemicalIngredientDao;
    }

    @Override
    public BasicIngredient findById(Long id) {
        return ingredientDao.findOne(id);
    }

    @Override
    public void remove(BasicIngredient object) {
            ingredientDao.delete(object);
    }

    @Override
    public List<BasicIngredient> findAll() {
        return ingredientDao.findAll();
    }

    @Override
    public void save(BasicIngredient object) {
        ingredientDao.save(object);
    }

    @Override
    public List<BasicIngredient> findByNameEndingWith(String suffix) {
        return ingredientDao.findByNameEndingWith(suffix);
    }

    //Problem 8
    @Override
    public List<BasicIngredient> findAllByNameInOrderByPriceAsc(Collection<String> name) {
        return ingredientDao.findAllByNameInOrderByPriceAsc(name);
    }

    //Problem 12
    @Override
    public List<BasicIngredient> findByNameIn(List<String> names) {
        return ingredientDao.findByNameIn(names);
    }

    //Problem 21
    @Override
    public void deleteIngByName(String name) {
        ingredientDao.deleteIngByName(name);
    }

    //Problem 22
    @Override
    public void updateIngPrice() {
        ingredientDao.updateIngPrice();
    }

    @Override
    public List<BasicChemicalIngredient> findAllByChecmicalFormula(String checmicalFormula) {
        return chemicalIngredientDao.findAllByChecmicalFormula(checmicalFormula);
    }
}
