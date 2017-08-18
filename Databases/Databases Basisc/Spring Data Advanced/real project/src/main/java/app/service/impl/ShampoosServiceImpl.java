package app.service.impl;

import app.dao.api.ClassicLabelDao;
import app.dao.api.ShampoosDao;
import app.model.BasicIngredient;
import app.model.ClassicLabel;
import app.service.api.ShampooService;
import app.model.BasicShampoos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 18.7.2017 г..
 */
@Service
@Transactional
public class ShampoosServiceImpl implements ShampooService<BasicShampoos, Long> {

    @Autowired
    private ShampoosDao dao;

    @Autowired
    private ClassicLabelDao classicLabelDao;

    @Override
    public BasicShampoos findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(BasicShampoos object) {
        dao.delete(object);
    }

    @Override
    public List<BasicShampoos> findAll(Class<BasicShampoos> serviceClass) {
        return dao.findAll();
    }

    @Override
    public void save(BasicShampoos object) {

    }

    @Override
    public void solveAllTasks() {
        List<BasicShampoos> shampoos = dao.findByBrand("Brand1");
        System.out.println(shampoos);

        List<BasicShampoos> shampoos2 = dao.findByBrandAndSize("Brand1",3);
        System.out.println(shampoos);

    }

    @Override
    public void solveAll() {
        List<BasicShampoos> shampoos = dao.findByBrand("Brand1");
        System.out.println(shampoos);

        List<BasicShampoos> shampoos2 = dao.findByBrandAndSize("Brand1",3);
        System.out.println(shampoos);

    }
    @Override
    public List<BasicShampoos> findBySizeOrLabel (int size,ClassicLabel label){
        return dao.findBySizeOrLabelOrderByPriceAsc(size,label);
    }

    @Override
    public List<BasicShampoos> findByBatchDate(@Param("date") Date date){
        return dao.findByBatchDate(date);
    }

    @Override
     public List<BasicShampoos> findByIngPriceSum(@Param("sum")BigDecimal sum){
        return dao.findByIngPriceSum(sum);
    }

    @Override
    public List<BasicShampoos> findByIng(BasicIngredient bi){
         return dao.findByIng(bi);
    }
}
