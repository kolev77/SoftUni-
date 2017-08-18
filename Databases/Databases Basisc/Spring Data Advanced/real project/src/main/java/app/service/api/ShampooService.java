package app.service.api;

import app.model.BasicIngredient;
import app.model.BasicShampoos;
import app.model.ClassicLabel;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 18.7.2017 г..
 */
public interface ShampooService<BasicShampoos, Long> extends ServiceInterface<BasicShampoos, Long> {
    void solveAllTasks();

    void solveAll();

    List<BasicShampoos> findBySizeOrLabel (int size, ClassicLabel label);


    List<app.model.BasicShampoos> findByBatchDate(@Param("date") Date date);

    List<BasicShampoos> findByIngPriceSum(@Param("sum") BigDecimal sum);

    List<app.model.BasicShampoos> findByIng(BasicIngredient bi);
}
