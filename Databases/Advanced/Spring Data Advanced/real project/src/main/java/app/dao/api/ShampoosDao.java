package app.dao.api;

import app.model.BasicIngredient;
import app.model.BasicShampoos;
import app.model.ClassicLabel;
import app.model.ProductionBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 18.7.2017 г..
 */
@Repository
public interface ShampoosDao extends JpaRepository<BasicShampoos, Long>,ShampoosDaoCustom {
    //Problem 1
    List<BasicShampoos> findByBrand(String brandName);

    //Problem 2
    List<BasicShampoos> findByBrandAndSize(String brand, int size);

    //Problem 3
    List<BasicShampoos> findBySizeOrLabelOrderByPriceAsc(int size, ClassicLabel label);


    //problem 15
    @Query(value = "SELECT s FROM BasicShampoos AS s INNER JOIN s.batch AS b WHERE b.date < :date")
    List<BasicShampoos> findByBatchDate(@Param("date")Date date);

    //Problem 13
    @Query(value = "SELECT s FROM BasicShampoos AS s INNER JOIN s.ingredients AS i GROUP BY  s HAVING SUM(i.price) < :sum")
    List<BasicShampoos> findByIngPriceSum(@Param("sum")BigDecimal sum);

}
