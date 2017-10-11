package app.dao.api;

import app.entities.BasicIngredient;
import app.entities.BasicShampoo;
import app.entities.ClassicLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface ShampooDao extends JpaRepository<BasicShampoo, Long>,ShampooDaoCustom {

    @Query("SELECT s FROM BasicShampoo AS s INNER JOIN s.ingredients as i WHERE i = :ing")
    List<BasicShampoo> shampooByIngredient(@Param("ing") BasicIngredient ingredient);

    //Problem1
    List<BasicShampoo> findByBrand(String brand);

    //Problem 2
    List<BasicShampoo> findByBrandAndSize(String brand, int size);

    //Problem 3
    List<BasicShampoo> findBySizeOrLabel(int size, ClassicLabel label);

    //Problem 4
    List<BasicShampoo> findByPriceGreaterThan(BigDecimal price);

    //Problem 15
    @Query(value = "SELECT s FROM BasicShampoo AS s INNER JOIN s.batch AS b where b.date < :date")
    List<BasicShampoo> findByBatchDate(@Param("date") Date date);

    //Problem 16
    @Query(value = "SELECT s FROM BasicShampoo AS s INNER JOIN s.ingredients AS i GROUP BY s HAVING SUM(i.price) < :sum")
    List<BasicShampoo> findByIngPriceSum(@Param("sum") BigDecimal sum);


}
