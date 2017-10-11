package app.dao.api;

import app.entities.BasicIngredient;
import app.entities.BasicShampoo;

import java.util.List;

public interface ShampooDaoCustom {
    List<BasicShampoo> findByIng(BasicIngredient bi);
}
