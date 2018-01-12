package app.dao.api;

import app.model.BasicIngredient;
import app.model.BasicShampoos;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ShampoosDaoCustom {
    List<BasicShampoos> findByIng(BasicIngredient bi);
}
