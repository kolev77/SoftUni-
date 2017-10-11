package app.service.impl;



import app.dao.api.ShampooDao;
import app.entities.model.BasicIngredient;
import app.entities.model.BasicShampoo;
import app.service.api.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShampooServiceImpl implements ShampooService{

    private final ShampooDao shampooDao;

    @Autowired
    public ShampooServiceImpl(ShampooDao shampooDao) {
        this.shampooDao = shampooDao;
    }


    @Override
    public BasicShampoo findById(Long id) {
        return shampooDao.findOne(id);
    }

    @Override
    public void remove(BasicShampoo object) {
        shampooDao.delete(object);
    }

    @Override
    public List<BasicShampoo> findAll() {
        return shampooDao.findAll();
    }

    @Override
    public void save(BasicShampoo object) {
            shampooDao.save(object);
    }

    @Override
    public List<BasicShampoo> shampooByIngredient(BasicIngredient ingredient) {
        return shampooDao.shampooByIngredient(ingredient);
    }
}
