package app.service.impl;


import app.dao.api.ShampooDao;
import app.entities.BasicIngredient;
import app.entities.BasicShampoo;
import app.entities.ClassicLabel;
import app.service.api.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ShampooServiceImpl implements ShampooService {

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

    //Problem 1
    @Override
    public List<BasicShampoo> findByBrand(String brand) {
        return shampooDao.findByBrand(brand);
    }

    //Problem 2
    @Override
    public List<BasicShampoo> findByBrandAndSize(String brand, int size) {
        return shampooDao.findByBrandAndSize(brand, size);
    }

    //Problem 3
    @Override
    public List<BasicShampoo> findBySizeOrLabel(int size, ClassicLabel label) {
        return shampooDao.findBySizeOrLabel(size, label);
    }

    //Problem 4
    @Override
    public List<BasicShampoo> findByPriceGreaterThan(BigDecimal price) {
        return shampooDao.findByPriceGreaterThan(price);
    }


    //Problem 15
    @Override
    public List<BasicShampoo> findByBatchDate(Date date) {
        return shampooDao.findByBatchDate(date);
    }


    //Problem 16
    @Override
    public List<BasicShampoo> findByIngPriceSum(BigDecimal sum) {
        return shampooDao.findByIngPriceSum(sum);
    }

    @Override
    public List<BasicShampoo> findByIng(BasicIngredient bi) {
        return shampooDao.findByIng(bi);
    }
}
