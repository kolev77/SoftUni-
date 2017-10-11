package app.service.api;

import app.entities.BasicIngredient;
import app.entities.BasicShampoo;
import app.entities.ClassicLabel;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ShampooService {

    BasicShampoo findById(Long id);

    void remove(BasicShampoo object);

    List<BasicShampoo> findAll();

    void save(BasicShampoo object);

    List<BasicShampoo> shampooByIngredient(BasicIngredient ingredient);

    //Problem1
    List<BasicShampoo> findByBrand(String brand);

    //Problem 2
    List<BasicShampoo> findByBrandAndSize(String brand, int size);


    //Problem 3
    List<BasicShampoo> findBySizeOrLabel(int size, ClassicLabel label);


    //Problem 4
    List<BasicShampoo> findByPriceGreaterThan(BigDecimal price);

    //Problem 15
    List<BasicShampoo> findByBatchDate(@Param("date")Date date);

    //Problem 16
    List<BasicShampoo> findByIngPriceSum(@Param("sum") BigDecimal sum);

     List<BasicShampoo> findByIng(BasicIngredient bi);
}
