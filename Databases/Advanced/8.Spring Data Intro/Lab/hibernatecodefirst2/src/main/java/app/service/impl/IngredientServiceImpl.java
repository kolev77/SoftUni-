package app.service.impl;

import app.dao.api.IngredientDao;
import app.entities.model.BasicIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import app.service.api.IngredientService;

import java.util.List;
@Service
@Transactional
public class IngredientServiceImpl implements IngredientService {

    private final IngredientDao ingredientDao;

    @Autowired
    public IngredientServiceImpl(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
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
}
